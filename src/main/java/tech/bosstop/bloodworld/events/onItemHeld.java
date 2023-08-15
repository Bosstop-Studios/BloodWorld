package tech.bosstop.bloodworld.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemHeldEvent;

import tech.bosstop.common.structures.races.BWMermaid;

public class onItemHeld extends BWEvent {

    public onItemHeld() {
        super();
    }

    private void underWaterMining(PlayerItemHeldEvent event) {
        BWMermaid mermaid = (BWMermaid) instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId());
        if(mermaid.isPickaxe()) mermaid.setMiningSpeed();
    }


    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        if(instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId()) instanceof BWMermaid) underWaterMining(event);

    }
    
}
