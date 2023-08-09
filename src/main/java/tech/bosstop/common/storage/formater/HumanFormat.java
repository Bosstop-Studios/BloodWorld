package tech.bosstop.common.storage.formater;

import java.util.List;

import tech.bosstop.common.structures.BWPlayer;

public class HumanFormat {
    private List<BWPlayer> players;

    public HumanFormat(List<BWPlayer> players) {
        this.players = players;
    }

    public List<BWPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<BWPlayer> players) {
        this.players = players;
    }
}
