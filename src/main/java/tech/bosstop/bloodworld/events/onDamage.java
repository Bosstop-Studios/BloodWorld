package tech.bosstop.bloodworld.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import tech.bosstop.common.structures.races.BWMermaid;
import tech.bosstop.common.structures.races.BWWerewolf;

public class onDamage extends BWEvent {

    public onDamage() {
        super();
    }

    private void damagedByWerewolf(EntityDamageByEntityEvent event) {
        BWWerewolf werewolf = (BWWerewolf) instance.getPlayerManager().getPlayer(event.getDamager().getUniqueId());
        event.setDamage(werewolf.getDamage(event.getDamage()));
    }

    private void damagedByMermaid(EntityDamageByEntityEvent event) {
        BWMermaid mermaid = (BWMermaid) instance.getPlayerManager().getPlayer(event.getEntity().getUniqueId());
        Player player = (Player) Bukkit.getPlayer(event.getDamager().getUniqueId());

        if(player.getInventory().getItemInMainHand().getType().toString().contains("TRIDENT")) {
            event.setDamage(mermaid.getTridentDamage(event.getDamage()));
            return;
        }

        if(mermaid.isUnderWater()) event.setDamage(mermaid.getUnderWaterDamage(event.getDamage()));
    }


    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player) {
            if(instance.getPlayerManager().getPlayer(event.getDamager().getUniqueId()) instanceof BWWerewolf) damagedByWerewolf(event);
        }

        if(event.getEntity() instanceof Player) {
            if(instance.getPlayerManager().getPlayer(event.getEntity().getUniqueId()) instanceof BWMermaid) damagedByMermaid(event);
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player) {
            if(instance.getPlayerManager().getPlayer(event.getEntity().getUniqueId()) instanceof BWMermaid) {
                if(event.getCause().equals(EntityDamageEvent.DamageCause.DROWNING)) event.setCancelled(true);
            }
        }
    }
}
