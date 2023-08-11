package tech.bosstop.bloodworld.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import tech.bosstop.common.structures.races.BWWerewolf;

public class onMove extends BWEvent {
    
    public onMove() {
        super();
    }

    private void werewolfNightVision(PlayerMoveEvent event) {
        BWWerewolf werewolf = (BWWerewolf) instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId());
        werewolf.setNightVision(event.getPlayer().getWorld().getTime() > 13000 && event.getPlayer().getWorld().getTime() < 23000);
        return;
    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if(instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId()) instanceof BWWerewolf) werewolfNightVision(event);
    }

}
