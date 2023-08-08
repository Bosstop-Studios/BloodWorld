package tech.bosstop.common.structures;

import java.util.UUID;

public class BWPlayer {

    private UUID uuid;

    private BWRace race = BWRace.HUMAN;    

    public BWPlayer(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public BWRace getRace() {
        return this.race;
    }

    public void setRace(BWRace race) {
        this.race = race;
    }
}
