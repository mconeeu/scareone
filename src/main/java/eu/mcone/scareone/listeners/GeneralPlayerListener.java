package eu.mcone.scareone.listeners;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.gameapi.api.event.player.GamePlayerLoadedEvent;
import eu.mcone.scareone.ScareOne;
import eu.mcone.scareone.objectives.SidebarObjective;
import eu.mcone.scareone.player.ScareOnePlayer;
import eu.mcone.scareone.util.HotbarItems;
import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
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
        ScareOnePlayer scareOnePlayer = ScareOne.getInstance().getScareOnePlayer(p);

        p.setGameMode(GameMode.SURVIVAL);
        p.teleport(scareOnePlayer.getLevel().getStartLocation());

        p.getInventory().setItem(0, HotbarItems.COLLECT_ITEM);
        p.getInventory().setItem(1, HotbarItems.WORLD_ITEM);

        for (ScareOnePlayer player : ScareOne.getInstance().getPlayers()) {
            p.hidePlayer(player.bukkit());
            player.bukkit().hidePlayer(p);
        }

        e.setJoinMessage(null);
    }

    @EventHandler
    public void onGamePlayerLoaded(GamePlayerLoadedEvent e) {

        if (CoreSystem.getInstance().getMongoDB().getCollection("scareone_profile").find(eq("uuid", e.getBukkitPlayer().getUniqueId().toString())).first() == null) {
            ScareOne.getInstance().getMessenger().send(e.getBukkitPlayer(), "§7Du scheinst neu auf ScareOne zu sein! Du erhälts eine Erklärung!");
        }

        new ScareOnePlayer(e.getCorePlayer());
        e.getCorePlayer().getScoreboard().setNewObjective(new SidebarObjective());


        ScareOnePlayer scareOnePlayer = ScareOne.getInstance().getScareOnePlayer(e.getBukkitPlayer());
        ScareOne.getInstance().getMessenger().send(e.getCorePlayer().bukkit(), scareOnePlayer.getLevel().getQuest().getText());
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        ScareOnePlayer scareOnePlayer = ScareOne.getInstance().getScareOnePlayer(e.getEntity());

        e.getEntity().teleport(scareOnePlayer.getLevel().getStartLocation());
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
        e.setCancelled(true);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        ScareOnePlayer kp = ScareOne.getInstance().getScareOnePlayer(e.getPlayer().getUniqueId());

        kp.saveData();
        kp.unregister();

        e.setQuitMessage(null);
    }
}
