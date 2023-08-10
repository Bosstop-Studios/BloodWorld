package tech.bosstop.bloodworld.core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.common.collect.ImmutableMap;

import tech.bosstop.bloodworld.BloodWorld;
import tech.bosstop.bloodworld.utilities.PowerFormatter;

public class BWTabList {
    
    private BloodWorld instance = BloodWorld.getInstance();

    private String format = "[faction] [race] [player]";

    private int taskID;

    private String tabListHeader() {
        StringBuilder header = new StringBuilder();

        Bukkit.getOnlinePlayers().forEach(player -> {
            String factionPrefix = instance.getFactionManager().getFactionByPlayer(player.getUniqueId()).getPrefix();
            String racePrefix = instance.getPlayerManager().getPlayer(player.getUniqueId()).getRace().toPrefix();
            String playerName = player.getDisplayName();

            if(factionPrefix == null) factionPrefix = "";

            String finalPlayerString = PowerFormatter.format(this.format, ImmutableMap.<String, String>builder()
            .put("faction", factionPrefix)
            .put("race", racePrefix)
            .put("player", playerName)
            .build(), '[', ']');

            header.append(finalPlayerString);
        });

        return header.toString();
    }

    private void updateTabList() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setPlayerListName(instance.getChat().colorize(tabListHeader()));
        }
    }

    public void enable() {
        taskID = Bukkit.getScheduler().runTaskTimer(instance, this::updateTabList, 0L, 20L).getTaskId();
    }

    public void disable() {
        Bukkit.getScheduler().cancelTask(taskID);
    }

}
