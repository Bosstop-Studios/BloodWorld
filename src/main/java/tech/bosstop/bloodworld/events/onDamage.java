package tech.bosstop.bloodworld.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import tech.bosstop.common.structures.races.BWWerewolf;

public class onDamage extends BWEvent {

    public onDamage() {
        super();
    }

    private void damagedByWerewolf(EntityDamageByEntityEvent event) {
        BWWerewolf werewolf = (BWWerewolf) instance.getPlayerManager().getPlayer(event.getDamager().getUniqueId());
        event.setDamage(werewolf.getDamage(event.getDamage()));
    }


    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player) {
            if(instance.getPlayerManager().getPlayer(event.getDamager().getUniqueId()) instanceof BWWerewolf) damagedByWerewolf(event);
        }
    }
}
