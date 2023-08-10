package tech.bosstop.bloodworld.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import tech.bosstop.common.structures.BWFaction;

public class BWFactionManager {
    
    private List<BWFaction> factions = new ArrayList<BWFaction>();

    public List<BWFaction> getFactions() {
        return this.factions;
    }

    public BWFaction getFaction(String name) {
        for(BWFaction faction : this.factions) {
            if(faction.getName().equalsIgnoreCase(name)) return faction;
        }
        return null;
    }

    public BWFaction getFactionByID(String id) {
        for(BWFaction faction : this.factions) {
            if(faction.getUUID().toString().equalsIgnoreCase(id)) return faction;
        }
        return null;
    }

    public BWFaction getFactionByPlayer(UUID player) {
        for(BWFaction faction : this.factions) {
            if(faction.getMembers().contains(player)) return faction;
        }
        return null;
    }

    public void addFaction(BWFaction faction) {
        this.factions.add(faction);
    }

    public void removeFaction(BWFaction faction) {
        this.factions.remove(faction);
    }

    public void removeFaction(String name) {
        this.factions.remove(getFaction(name));
    }

    public void removeFactionByID(String id) {
        this.factions.remove(getFactionByID(id));
    }

    public boolean factionExists(String name) {
        return getFaction(name) != null;
    }

    public boolean factionExistsByID(String id) {
        return getFactionByID(id) != null;
    }

    public void setFactions(List<BWFaction> factions) {
        this.factions = factions;
    }
    
}
