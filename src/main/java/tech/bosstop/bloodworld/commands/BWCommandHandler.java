package tech.bosstop.bloodworld.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import tech.bosstop.bloodworld.BloodWorld;

public class BWCommandHandler implements CommandExecutor, TabCompleter {

    private final BloodWorld instance = BloodWorld.getInstance();
    
    private HashMap<String, BWCommand> bwCommands = new HashMap<>();

    public BWCommandHandler() {
        instance.getCommand("bloodworld").setExecutor(this::onCommand);
        instance.getCommand("bloodworld").setTabCompleter(this::onTabComplete);
    }

    private String[] removeFirst(String[] args) {
        String[] newArgs = new String[args.length - 1];
        System.arraycopy(args, 1, newArgs, 0, args.length - 1);
        return newArgs;
    }

    public void registerCommand(String command, BWCommand bwCommand) {
        this.bwCommands.put(command, bwCommand);
    }

    public void register() {


    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length == 0) return true;
        if(this.bwCommands.containsKey(args[0])) {
            if (this.bwCommands.get(args[0]).getPermission() != null) {
                if (!commandSender.hasPermission(this.bwCommands.get(args[0]).getPermission())) {
                    instance.getChat().send(commandSender, "&4You don't have permission to use this command.");
                    return true;
                }
            }
            return this.bwCommands.get(args[0]).onCommand(commandSender, command, s, this.removeFirst(args));
        } else {
            instance.getChat().send(commandSender, "&4Unknown command. Type &6/bw help &4for help.");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> tabList = new ArrayList<>();
        if(args.length == 1) {
            tabList.addAll(this.bwCommands.keySet());
        } else {
            if(this.bwCommands.containsKey(args[0])) {
                tabList = this.bwCommands.get(args[0]).onTab(commandSender, command, s, this.removeFirst(args));
            }
        }
        if(tabList.size() == 0) return null;
        return tabList;
    }

    public HashMap<String, BWCommand> getBwCommands() {
        return this.bwCommands;
    }
}
