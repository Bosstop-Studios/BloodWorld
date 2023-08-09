package tech.bosstop.bloodworld.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tech.bosstop.bloodworld.BloodWorld;

public abstract class BWCommand {
    
    protected BloodWorld instance;

    public BWCommand(String command) {
        super();
        this.instance = BloodWorld.getInstance();
        this.instance.getCommandHandler().putCommand(command, this);
    }

    protected boolean argsNeeded(CommandSender sender, String[] args, String usage, int argsNeeded) {
        if (args.length < argsNeeded) {
            instance.getChat().send(sender, "Not enough arguments.");
            instance.getChat().send(sender, "Usage: " + usage);
            return true;
        }
        return false;
    }

    protected boolean isPlayer(CommandSender sender) {
        if (!(sender instanceof org.bukkit.entity.Player)) {
            instance.getChat().send(sender, "&4You must be a player to use this command.");
            return false;
        }
        return true;
    }

    public abstract String getDescription();

    public abstract String getUsage();

    public abstract String getPermission();

    public abstract boolean onCommand(CommandSender sender, Command command, String label, String[] args);

    public abstract List<String> onTab(CommandSender sender, Command command, String label, String[] args);
}
