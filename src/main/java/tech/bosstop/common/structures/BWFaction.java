package tech.bosstop.common.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BWFaction {

    private UUID uuid;

    private String name;

    private String prefix;

    private UUID leader;

    private List<UUID> members = new ArrayList<UUID>();

    private List<UUID> allies = new ArrayList<UUID>();

    private List<UUID> enemies = new ArrayList<UUID>();

    public BWFaction(String name, UUID leader) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.leader = leader;
        this.prefix = "&7[&a" + name + "&7]";
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public UUID getLeader() {
        return this.leader;
    }

    public List<UUID> getMembers() {
        return this.members;
    }

    public List<UUID> getAllies() {
        return this.allies;
    }

    public List<UUID> getEnemies() {
        return this.enemies;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setLeader(UUID leader) {
        this.leader = leader;
    }

    public void addMember(UUID member) {
        this.members.add(member);
    }

    public void removeMember(UUID member) {
        this.members.remove(member);
    }

    public void addAlly(UUID ally) {
        this.allies.add(ally);
    }

    public void removeAlly(UUID ally) {
        this.allies.remove(ally);
    }

    public void addEnemy(UUID enemy) {
        this.enemies.add(enemy);
    }

    public void removeEnemy(UUID enemy) {
        this.enemies.remove(enemy);
    }

    public void setMembers(List<UUID> members) {
        this.members = members;
    }

    public void setAllies(List<UUID> allies) {
        this.allies = allies;
    }

    public void setEnemies(List<UUID> enemies) {
        this.enemies = enemies;
    }

    public boolean isMember(UUID member) {
        return this.members.contains(member);
    }

    public boolean isAlly(UUID ally) {
        return this.allies.contains(ally);
    }

    public boolean isEnemy(UUID enemy) {
        return this.enemies.contains(enemy);
    }

    public boolean isLeader(UUID leader) {
        return this.leader.equals(leader);
    }
    
}
