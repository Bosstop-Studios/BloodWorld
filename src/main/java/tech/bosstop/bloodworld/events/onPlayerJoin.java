package tech.bosstop.bloodworld.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import tech.bosstop.common.structures.BWPlayer;

public class onPlayerJoin extends BWEvent {

    public onPlayerJoin() {
        super();
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        if(!event.getPlayer().hasPlayedBefore()) instance.getPlayerManager().addPlayer(new BWPlayer(event.getPlayer().getUniqueId()));
    }
}