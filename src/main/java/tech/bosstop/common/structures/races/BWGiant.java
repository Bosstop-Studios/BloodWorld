package tech.bosstop.common.structures.races;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import tech.bosstop.common.structures.BWPlayer;
import tech.bosstop.common.structures.BWRace;

public class BWGiant extends BWPlayer {

    public BWGiant(UUID uuid) {
        super(uuid);
        super.setRace(BWRace.GIANT);
    }

    public void setMaxHealth() {
        Player player = Bukkit.getPlayer(this.getUUID());
        player.setHealth(player.getHealth() * 1.5);
        player.setHealthScale(player.getHealth() * 1.5);
    }

    public void setAbsorption() {
        Player player = Bukkit.getPlayer(this.getUUID());
        if(player.getWorld().getTime() > 0 && player.getWorld().getTime() < 12000) {
            player.setAbsorptionAmount(player.getAbsorptionAmount() * 1.5);
        }
    }
}

