package tech.bosstop.bloodworld;

import org.bukkit.plugin.java.JavaPlugin;

import tech.bosstop.bloodworld.core.BWPlayerManager;
import tech.bosstop.bloodworld.utilities.Chat;

public class BloodWorld extends JavaPlugin {

    private static BloodWorld instance;

    private Chat chat;

    private BWPlayerManager playerManager;

    private String[] startup = {
        "                      ",
        "&b██████  ██     ██ &r", 
        "&b██   ██ ██     ██ &r",
        "&b██████  ██  █  ██ &r",
        "&b██   ██ ██ ███ ██ &r",
        "&b██████   ███ ███  &r",
        "                      ",
        "&aVersion: %version% &r",
        "&aPlayers: %player% &r",
        "&aFactions: %player% &r",
    };

    @Override
    public void onEnable() {
        instance = this;
        this.chat = new Chat();
        this.playerManager = new BWPlayerManager();

        for(String line : startup) {
            line = line.replace("%version%", getDescription().getVersion());
            line = line.replace("%player%", this.playerManager.getPlayers().size() + "");

            this.chat.console(line);
        }

        this.chat.console("&aPlugin enabled.");

        this.chat.console(this.playerManager.getPlayers().toString());
    }

    @Override
    public void onDisable() {
        this.chat.console("&cPlugin disabled.");
    }

    public Chat getChat() {
        return chat;
    }

    public static BloodWorld getInstance() {
        return instance;
    }
}
