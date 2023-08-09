package tech.bosstop.common.storage.formater;

import java.util.List;

import tech.bosstop.common.structures.races.BWWerewolf;

public class WerewolfFormat {
    
    List<BWWerewolf> werewolves;

    public WerewolfFormat(List<BWWerewolf> werewolves) {
        this.werewolves = werewolves;
    }

    public List<BWWerewolf> getWerewolves() {
        return werewolves;
    }

    public void setWerewolves(List<BWWerewolf> werewolves) {
        this.werewolves = werewolves;
    }
}
