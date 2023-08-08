package tech.bosstop.bloodworld.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import tech.bosstop.common.structures.BWPlayer;
import tech.bosstop.common.structures.races.BWMermaid;
import tech.bosstop.common.structures.races.BWVampire;

public class BWPlayerManager {

    private List<BWPlayer> players = new ArrayList<BWPlayer>();

    public BWPlayerManager() {
        this.addPlayer(new BWVampire(UUID.randomUUID()));
        this.addPlayer(new BWMermaid(UUID.randomUUID()));
    }

    public List<BWPlayer> getPlayers() {
        return players;
    }

    public void addPlayer(BWPlayer player) {
        this.players.add(player);
    }

    public void removePlayer(BWPlayer player) {
        this.players.remove(player);
    }

    public BWPlayer getPlayer(UUID uuid) {
        for (BWPlayer player : this.players) {
            if (player.getUUID().equals(uuid)) {
                return player;
            }
        }
        return null;
    }

    public void setPlayers(List<BWPlayer> players) {
        this.players = players;
    }    
}
