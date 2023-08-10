package tech.bosstop.bloodworld.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.google.common.collect.ImmutableMap;

import tech.bosstop.bloodworld.utilities.PowerFormatter;

public class onChat extends BWEvent {

    private String format = "[faction] [race] [player]: [message]";

    public onChat() {
        super();
    }

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        String factionPrefix = instance.getFactionManager().getFactionByPlayer(event.getPlayer().getUniqueId()).getPrefix();
        String racePrefix = instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId()).getRace().toPrefix();
        String playerName = event.getPlayer().getDisplayName();
        String message = event.getMessage();

        if(factionPrefix == null) factionPrefix = "";

        String finalPlayerString = PowerFormatter.format(this.format, ImmutableMap.<String, String>builder()
        .put("faction", factionPrefix)
        .put("race", racePrefix)
        .put("player", playerName)
        .put("message", message)
        .build(), '[', ']');
    
        event.setFormat(instance.getChat().colorize(finalPlayerString));

    }
    
}
