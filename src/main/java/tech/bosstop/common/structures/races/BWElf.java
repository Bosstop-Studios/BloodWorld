package tech.bosstop.common.structures.races;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import tech.bosstop.common.structures.BWPlayer;
import tech.bosstop.common.structures.BWRace;

public class BWElf extends BWPlayer {
    
    public BWElf(UUID uuid) {
        super(uuid);
        super.setRace(BWRace.ELF);
    }

    public boolean isBowDamage() {
        Player player = Bukkit.getPlayer(this.getUUID());
        return player.getInventory().getItemInMainHand().getType() == Material.BOW;
    }

    public double getDamage(double damage) {
        Player player = Bukkit.getPlayer(this.getUUID());
        if(player.getWorld().getTime() > 0 && player.getWorld().getTime() < 12000 && this.isBowDamage()) {
            return damage * 1.5;
        }
        return damage;
    }

    public double getRegen(double regen) {
        Player player = Bukkit.getPlayer(this.getUUID());
        if(player.getWorld().getTime() > 0 && player.getWorld().getTime() < 12000) {
            return regen * 1.5;
        }
        return regen;
    }
}
