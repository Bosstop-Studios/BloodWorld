package tech.bosstop.common.structures.races;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tech.bosstop.common.structures.BWPlayer;
import tech.bosstop.common.structures.BWRace;

public class BWMermaid extends BWPlayer {

    public BWMermaid(UUID uuid) {
        super(uuid);
        super.setRace(BWRace.MERMAID);
    }

    public double getUnderWaterDamage(double damage) {
        return damage * 1.5;
    }

    public double getTridentDamage(double damage) {
        return damage * 2;
    }

    public boolean isUnderWater() {
        Player player = Bukkit.getPlayer(this.getUUID());
        return player.getLocation().getBlock().getType() == Material.WATER;
    }

    public void setSpeed() {
        Player player = Bukkit.getPlayer(this.getUUID());
        if (this.isUnderWater()) {
            player.setWalkSpeed(0.3f);
        } else {
            player.setWalkSpeed(0.2f);
        }
    }

    public void setBreath() {
        Player player = Bukkit.getPlayer(this.getUUID());
        if (this.isUnderWater()) {
            player.setRemainingAir(20);
        }
    }

    public void setMiningSpeed() {
        Player player = Bukkit.getPlayer(this.getUUID());
        if(this.isUnderWater()) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 0));
        } else {
            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
        }
    }

}
