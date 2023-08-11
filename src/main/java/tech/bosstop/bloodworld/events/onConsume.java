package tech.bosstop.bloodworld.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import tech.bosstop.common.structures.races.BWWerewolf;

public class onConsume extends BWEvent {
    
    public onConsume() {
        super();
    }

    private void werewolfEat(PlayerItemConsumeEvent event) {
        BWWerewolf werewolf = (BWWerewolf) instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId());

        if(!werewolf.canEat(event.getItem())) {
            event.setCancelled(true);
            instance.getChat().send(event.getPlayer(), "&cYou can only eat meat!");
        }
    }

    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent event) {
        if(instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId()) instanceof BWWerewolf) werewolfEat(event);
    }
}
