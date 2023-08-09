package tech.bosstop.bloodworld.events;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import tech.bosstop.bloodworld.BloodWorld;

public class BWEvent implements Listener {
    
    protected BloodWorld instance;

    public BWEvent() {
        super();
        this.instance = BloodWorld.getInstance();
        Bukkit.getPluginManager().registerEvents(this, instance);
    }
}
