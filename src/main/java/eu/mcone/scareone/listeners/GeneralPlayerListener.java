package eu.mcone.scareone.listeners;

import eu.mcone.scareone.ScareOne;
import eu.mcone.scareone.objectives.SidebarObjective;
import eu.mcone.scareone.player.ScareOnePlayer;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.gameapi.api.event.player.GamePlayerLoadedEvent;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static com.mongodb.client.model.Filters.eq;

public class GeneralPlayerListener implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setGameMode(GameMode.SURVIVAL);

        e.setJoinMessage(null);
    }

    @EventHandler
    public void onGamePlayerLoaded(GamePlayerLoadedEvent e) {

        if (CoreSystem.getInstance().getMongoDB().getCollection("scareone_profile").find(eq("uuid", e.getBukkitPlayer().getUniqueId().toString())).first() == null) {
            ScareOne.getInstance().getMessenger().send(e.getBukkitPlayer(), "§7Du scheinst neu auf ScareOne zu sein! Du erhälts eine Erklärung!");
        }

        new ScareOnePlayer(e.getCorePlayer());
        e.getCorePlayer().getScoreboard().setNewObjective(new SidebarObjective());
    }

    @EventHandler
    public void onFight(PlayerDeathEvent e) {

    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        if (e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void on(PlayerItemDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        Entity ent = e.getEntity();

        if (ent instanceof Player) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                e.setCancelled(true);
            } else if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        ScareOnePlayer kp = ScareOne.getInstance().getScareOnePlayer(e.getPlayer().getUniqueId());

        kp.saveData();
        kp.unregister();

        e.setQuitMessage(null);
    }
}
