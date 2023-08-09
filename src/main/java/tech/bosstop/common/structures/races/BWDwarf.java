package tech.bosstop.common.structures.races;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tech.bosstop.common.structures.BWPlayer;
import tech.bosstop.common.structures.BWRace;

public class BWDwarf extends BWPlayer {

    public BWDwarf(UUID uuid) {
        super(uuid);
        super.setRace(BWRace.DWARF);
    }

    public boolean isPickaxe() {
        List<Material> pickaxes = Arrays.asList(Material.WOODEN_PICKAXE, Material.STONE_PICKAXE, 
        Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE);
        Player player = Bukkit.getPlayer(this.getUUID());
        return pickaxes.contains(player.getInventory().getItemInMainHand().getType());
    }

    public boolean isPickaxeDamage() {
        List<Material> pickaxes = Arrays.asList(Material.WOODEN_PICKAXE, Material.STONE_PICKAXE, 
        Material.IRON_PICKAXE, Material.GOLDEN_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE);

        Player player = Bukkit.getPlayer(this.getUUID());

        return pickaxes.contains(player.getInventory().getItemInMainHand().getType());
    }

    public double getDamage(double damage) {
        if(this.isPickaxeDamage()) {
            return damage * 1.5;
        }
        return damage;
    }

    public int getDiscount(int exp) {
        return (int) Math.round(exp - (exp * 0.5));
    }

    public void addMiningSpeedEffect() {
        Player player = Bukkit.getPlayer(this.getUUID());
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 1));
    }
    
    public void removeMiningSpeedEffect() {
        Player player = Bukkit.getPlayer(this.getUUID());
        player.removePotionEffect(PotionEffectType.FAST_DIGGING);
    }
}
