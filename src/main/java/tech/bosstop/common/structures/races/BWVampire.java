package tech.bosstop.common.structures.races;

import java.util.UUID;

import tech.bosstop.common.structures.BWPlayer;
import tech.bosstop.common.structures.BWRace;

public class BWVampire extends BWPlayer {

    private int lives = 10;

    public BWVampire(UUID uuid) {
        super(uuid);
        super.setRace(BWRace.VAMPIRE);
    }    

    public int getLives() {
        return this.lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void addLife() {
        this.lives++;
    }

    public void removeLife() {
        if (this.lives < 5) return;
        this.lives--;
    }
}
