package tech.bosstop.common.storage.formater;

import java.util.List;

import tech.bosstop.common.structures.BWFaction;

public class FactionFormat {
    
    List<BWFaction> factions;

    public FactionFormat(List<BWFaction> factions) {
        this.factions = factions;
    }

    public List<BWFaction> getFactions() {
        return this.factions;
    }

    public void setFactions(List<BWFaction> factions) {
        this.factions = factions;
    }

}
