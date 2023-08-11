package tech.bosstop.common.structures.races;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import tech.bosstop.common.structures.BWPlayer;
import tech.bosstop.common.structures.BWRace;

public class BWWerewolf extends BWPlayer {

    public BWWerewolf(UUID uuid) {
        super(uuid);
        super.setRace(BWRace.WEREWOLF);
    }

    public boolean hasNightVision() {
        Player player = Bukkit.getPlayer(this.getUUID());
        return player.hasPotionEffect(PotionEffectType.NIGHT_VISION);
    }

    public void setNightVision(boolean nightVision) {
        Player player = Bukkit.getPlayer(this.getUUID());
        if (nightVision) {
            if(this.hasNightVision()) return;
            player.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(Integer.MAX_VALUE, 0));
        } else {
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
        }
    }

    public double getDamage(double damage) {
        Player player = Bukkit.getPlayer(this.getUUID());
        if (player.getWorld().getTime() > 13000 && player.getWorld().getTime() < 23000) {
            return damage * 2;
        }
        return damage;
    }

    public boolean canEat(ItemStack item) {
        List<Material> meat = List.of(Material.BEEF, Material.COOKED_BEEF, Material.CHICKEN, Material.COOKED_CHICKEN,
        Material.MUTTON, Material.COOKED_MUTTON, Material.PORKCHOP, Material.COOKED_PORKCHOP,
        Material.RABBIT, Material.COOKED_RABBIT, Material.ROTTEN_FLESH);

        return meat.contains(item.getType());
    }

}
