package tech.bosstop.bloodworld;

import org.bukkit.plugin.java.JavaPlugin;

import tech.bosstop.bloodworld.utilities.Chat;

public class BloodWorld extends JavaPlugin {

    private static BloodWorld instance;

    private Chat chat;

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
    };

    @Override
    public void onEnable() {
        instance = this;
        this.chat = new Chat();

        for(String line : startup) {
            line.replace("%version%", getDescription().getVersion());

            this.chat.console(line);
        }

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
