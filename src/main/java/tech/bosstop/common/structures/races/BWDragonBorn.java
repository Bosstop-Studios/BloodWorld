package tech.bosstop.common.structures.races;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import tech.bosstop.common.structures.BWPlayer;
import tech.bosstop.common.structures.BWRace;

public class BWDragonBorn extends BWPlayer {

    public BWDragonBorn(UUID uuid) {
        super(uuid);
        super.setRace(BWRace.DRAGONBORN);
    }

    public boolean isOnFire() {
        Player player = Bukkit.getPlayer(this.getUUID());
        return player.getLocation().getBlock().getType() == Material.FIRE || player.getLocation().getBlock().getType() == Material.LAVA;
    }

    public boolean isSword() {
        List<Material> swords = List.of(Material.WOODEN_SWORD, Material.STONE_SWORD, Material.IRON_SWORD, 
        Material.GOLDEN_SWORD, Material.DIAMOND_SWORD, Material.NETHERITE_SWORD);
        Player player = Bukkit.getPlayer(this.getUUID());
        return swords.contains(player.getInventory().getItemInMainHand().getType());
    }

    public double getDamage(double damage) {
        if(this.isSword()) {
            return damage * 1.5;
        }
        return damage;
    }

}
