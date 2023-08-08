package tech.bosstop.common.structures.races;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import tech.bosstop.common.structures.BWPlayer;

public class BWDarkElf extends BWPlayer {

    public BWDarkElf(UUID uuid) {
        super(uuid);
    }

    public boolean isBowDamage() {
        Player player = Bukkit.getPlayer(this.getUUID());
        return player.getInventory().getItemInMainHand().getType() == Material.BOW;
    }

    public boolean hasNightVision() {
        Player player = Bukkit.getPlayer(this.getUUID());
        return player.hasPotionEffect(PotionEffectType.NIGHT_VISION);
    }

    public void setNightVision(boolean nightVision) {
        Player player = Bukkit.getPlayer(this.getUUID());
        if (nightVision) {
            player.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(Integer.MAX_VALUE, 0));
        } else {
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
        }
    }

    public double getDamage(double damage) {
        Player player = Bukkit.getPlayer(this.getUUID());
        if(player.getWorld().getTime() > 13000 && player.getWorld().getTime() < 23000 && this.isBowDamage()) {
            return damage * 1.5;
        }
        return damage;
    }

}
