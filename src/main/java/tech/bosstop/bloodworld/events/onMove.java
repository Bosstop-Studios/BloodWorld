package tech.bosstop.bloodworld.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tech.bosstop.common.structures.races.BWElf;
import tech.bosstop.common.structures.races.BWMermaid;
import tech.bosstop.common.structures.races.BWWerewolf;

public class onMove extends BWEvent {
    
    public onMove() {
        super();
    }

    private void werewolfNightVision(PlayerMoveEvent event) {
        BWWerewolf werewolf = (BWWerewolf) instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId());
        werewolf.setNightVision(event.getPlayer().getWorld().getTime() > 13000 && event.getPlayer().getWorld().getTime() < 23000);
        return;
    }

    private void mermaidSpeed(PlayerMoveEvent event) {
        BWMermaid mermaid = (BWMermaid) instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId());
        if(mermaid.isUnderWater()) {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
        } else {
            event.getPlayer().removePotionEffect(PotionEffectType.SPEED);
        }
        return;
    }

    private void elfRegen(PlayerMoveEvent event) {
        BWElf elf = (BWElf) instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId());
        //if(elf.is)
    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if(instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId()) instanceof BWWerewolf) werewolfNightVision(event);
        if(instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId()) instanceof BWMermaid) mermaidSpeed(event);
        if(instance.getPlayerManager().getPlayer(event.getPlayer().getUniqueId()) instanceof BWElf) elfRegen(event);
    }

}
