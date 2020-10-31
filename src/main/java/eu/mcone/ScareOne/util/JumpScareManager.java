package eu.mcone.ScareOne.util;

import eu.mcone.ScareOne.enums.ScareLocations;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class JumpScareManager {

    public void playGateWayJumpScare(Player player) {

        Vector normalBoost = player.getLocation().getDirection().multiply(2).setY(0.5);

        player.playSound(player.getLocation(), Sound.ENDERDRAGON_DEATH,10,5);
        player.playSound(player.getLocation(), Sound.NOTE_PLING, 5, 7);
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 3, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2, 1));
        player.spigot().playEffect(player.getLocation(), Effect.EXPLOSION_LARGE, 1, 1, 1, 1, 1, 3, 5, 19);
        player.setVelocity(normalBoost);


    }

    public void playJumpScare(Player player) {
        player.playSound(player.getLocation(), Sound.EXPLODE,10,5);
        player.playSound(player.getLocation(), Sound.NOTE_BASS, 5, 7);
        player.playSound(player.getLocation(), Sound.FIZZ,10,5);

        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1, 1));
        player.spigot().playEffect(player.getLocation(), Effect.FIREWORKS_SPARK, 1, 1, 1, 1, 1, 3, 30, 15);
    }

    public void playScare(Player player, ScareLocations scareLocations) {
        if (scareLocations.getName().equalsIgnoreCase(ScareLocations.GATEWAY.getName())) {
            playGateWayJumpScare(player);
        } else if (scareLocations.getName().equalsIgnoreCase(ScareLocations.JUMPSCARE.getName())) {
            playJumpScare(player);
        }
    }
}
