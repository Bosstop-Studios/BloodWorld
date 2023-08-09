package tech.bosstop.bloodworld.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

import tech.bosstop.common.structures.races.BWVampire;

public class onPlayerDeath extends BWEvent {
    
    public onPlayerDeath() {
        super();
    }

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {

        if(instance.getPlayerManager().getPlayer(event.getEntity().getUniqueId()) instanceof BWVampire && event.getEntity().getKiller() instanceof Player) {
            BWVampire vampire = (BWVampire) instance.getPlayerManager().getPlayer(event.getEntity().getUniqueId());
            vampire.removeLife();
            instance.getChat().send(event.getEntity(), "You have lost a life!");
        }

        if(instance.getPlayerManager().getPlayer(event.getEntity().getKiller().getUniqueId()) instanceof BWVampire && event.getEntity() instanceof Player) {
            BWVampire vampire = (BWVampire) instance.getPlayerManager().getPlayer(event.getEntity().getKiller().getUniqueId());
            vampire.addLife();
            instance.getChat().send(event.getEntity().getKiller(), "You have gained a life!");
        }

    }
}
