package tech.bosstop.bloodworld;

import org.bukkit.plugin.java.JavaPlugin;

import tech.bosstop.bloodworld.commands.BWCommandHandler;
import tech.bosstop.bloodworld.core.BWFactionManager;
import tech.bosstop.bloodworld.core.BWPlayerManager;
import tech.bosstop.bloodworld.events.BWEventHandler;
import tech.bosstop.bloodworld.utilities.Chat;
import tech.bosstop.common.storage.JSONStore;

public class BloodWorld extends JavaPlugin {

    private static BloodWorld instance;

    private JSONStore jsonStore;

    private Chat chat;

    private BWFactionManager factionManager;

    private BWPlayerManager playerManager;

    private BWEventHandler eventHandler;

    private BWCommandHandler commandHandler;

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
        "&aFactions: %factions% &r",
    };

    @Override
    public void onEnable() {
        instance = this;
        this.chat = new Chat();
        this.factionManager = new BWFactionManager();
        this.playerManager = new BWPlayerManager();
        this.eventHandler = new BWEventHandler();
        this.commandHandler = new BWCommandHandler();

        this.jsonStore = new JSONStore();

        try {
            this.jsonStore.enable();
            this.eventHandler.register();

            for(String line : startup) {
                line = line.replace("%version%", getDescription().getVersion());
                line = line.replace("%player%", this.playerManager.getPlayers().size() + "");
                line = line.replace("%factions%", this.factionManager.getFactions().size() + "");

                this.chat.console(line);
            }
        } catch(Exception e) {
            this.chat.console("&cError while checking files.");
            e.printStackTrace();
        } finally {
            this.chat.console("&aBloodWorld enabled!");
        }
    }

    @Override
    public void onDisable() {
        try {
            this.jsonStore.disable();
        } catch (Exception e) {
            this.chat.console(e.getMessage());
        } finally {
            this.chat.console("&cBloodWorld disabled!");
        }
    }

    public Chat getChat() {
        return this.chat;
    }

    public BWFactionManager getFactionManager() {
        return this.factionManager;
    }

    public BWPlayerManager getPlayerManager() {
        return this.playerManager;
    }

    public BWCommandHandler getCommandHandler() {
        return this.commandHandler;
    }

    public static BloodWorld getInstance() {
        return instance;
    }
}
