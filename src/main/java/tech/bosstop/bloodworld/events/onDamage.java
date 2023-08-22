package tech.bosstop.bloodworld.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import tech.bosstop.common.structures.races.BWElf;
import tech.bosstop.common.structures.races.BWMermaid;
import tech.bosstop.common.structures.races.BWSerpentine;
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
        BWMermaid mermaid = (BWMermaid) instance.getPlayerManager().getPlayer(event.getDamager().getUniqueId());
        Player player = (Player) Bukkit.getPlayer(event.getDamager().getUniqueId());

        if(player.getInventory().getItemInMainHand().getType().toString().contains("TRIDENT")) {
            event.setDamage(mermaid.getTridentDamage(event.getDamage()));
            return;
        }

        if(mermaid.isUnderWater()) event.setDamage(mermaid.getUnderWaterDamage(event.getDamage()));
    }

    private void damagedBySerpentine(EntityDamageByEntityEvent event) {
        BWSerpentine serpentine = (BWSerpentine) instance.getPlayerManager().getPlayer(event.getDamager().getUniqueId());
        if(serpentine.poisonPunch((Player) event.getEntity())) event.setCancelled(true);
    }

    private void damagedByElf(EntityDamageByEntityEvent event) {
        BWElf elf = (BWElf) instance.getPlayerManager().getPlayer(event.getDamager().getUniqueId());
        if(elf.isBowDamage()) event.setDamage(elf.getDamage(event.getDamage()));
    }


    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if(event.getDamager().getType() != EntityType.PLAYER || event.getEntity().getType() != EntityType.PLAYER) return;

        if(instance.getPlayerManager().getPlayer(event.getDamager().getUniqueId()) instanceof BWWerewolf) damagedByWerewolf(event);

        if(instance.getPlayerManager().getPlayer(event.getEntity().getUniqueId()) instanceof BWMermaid) damagedByMermaid(event);

        if(instance.getPlayerManager().getPlayer(event.getEntity().getUniqueId()) instanceof BWSerpentine) damagedBySerpentine(event);

        if(instance.getPlayerManager().getPlayer(event.getDamager().getUniqueId()) instanceof BWElf) damagedByElf(event);
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
