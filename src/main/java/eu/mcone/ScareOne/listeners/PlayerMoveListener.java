package eu.mcone.ScareOne.listeners;

import eu.mcone.ScareOne.ScareOne;
import eu.mcone.ScareOne.enums.ScareLocations;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void on(PlayerMoveEvent e) {
        Player player = e.getPlayer();

        int max = 10;

        for (int i = 0; i < max; i++) {
            i++;
            for (ScareLocations scareLocation : ScareLocations.values()) {
                if (ScareOne.getInstance().getGameWorld().getLocation(scareLocation.getLocation().toString() + i) != null) {
                    Location location = ScareOne.getInstance().getGameWorld().getLocation(scareLocation.getLocation().toString() + i);
                    if (player.getWorld().equals(scareLocation.getLocation().getWorld()) && player.getLocation().distance(location) <= 1) {
                        ScareOne.getInstance().getJumpScareManager().playScare(player, scareLocation);
                    }
                }
            }
        }
    }
}
