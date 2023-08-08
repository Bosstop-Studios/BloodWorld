package tech.bosstop.common.structures.races;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tech.bosstop.common.structures.BWPlayer;
import tech.bosstop.common.structures.BWRace;

public class BWSerpentine extends BWPlayer {

    public BWSerpentine(UUID uuid) {
        super(uuid);
        super.setRace(BWRace.SERPENTINE);
    }

    public boolean poisonPunch(Player target) {
        Player player = Bukkit.getPlayer(this.getUUID());
        if(player.getInventory().getItemInMainHand().getType() != Material.AIR) return false;
        return target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20, 1));
    }

}
