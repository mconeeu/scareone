package eu.mcone.scareone.listeners;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.scareone.ScareOne;
import eu.mcone.scareone.enums.CollectItems;
import eu.mcone.scareone.enums.Levels;
import eu.mcone.scareone.inventorys.CollectInventory;
import eu.mcone.scareone.inventorys.LevelsInventory;
import eu.mcone.scareone.player.ScareOnePlayer;
import eu.mcone.scareone.util.HotbarItems;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ScareOnePlayer scareOnePlayer = ScareOne.getInstance().getScareOnePlayer(p);

        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            for (CollectItems itemsLocations : CollectItems.values()) {
                if (e.getClickedBlock().getLocation() == itemsLocations.getBlockLocation()) {
                    CorePlayer corePlayer = CoreSystem.getInstance().getCorePlayer(p);

                    ScareOne.getInstance().getMessenger().sendSuccess(p, "Du hast das Item" + itemsLocations.getName() + " erfolgreich gesammelt!");
                    ScareOne.getInstance().getMessenger().send(p, "§a[+ 100 Coins]");

                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 4, 1));

                    corePlayer.addCoins(100);
                    scareOnePlayer.addCollectItem(itemsLocations);
                }
            }

            for (Levels levels : Levels.values()) {
                if (e.getClickedBlock().getLocation() == levels.getEndLocation()) {
                    scareOnePlayer.setLevel(scareOnePlayer.getLevelAmount() + 1);

                    p.teleport(scareOnePlayer.getLevel().getStartLocation());
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
                    p.playSound(p.getLocation(), Sound.SPLASH, 1, 1);

                    ScareOne.getInstance().getMessenger().sendSuccess(p, "Du hast das Level abgeschlossen.");
                    ScareOne.getInstance().getMessenger().send(p, scareOnePlayer.getLevel().getQuest().getText());

                }
            }

        }
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            ItemStack itemStack = e.getItem();
            if (itemStack != null) {
                if (itemStack.equals(HotbarItems.COLLECT_ITEM)) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2, 1));
                    new CollectInventory(p);
                } else if (itemStack.equals(HotbarItems.WORLD_ITEM)) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 2, 1));
                    new LevelsInventory(p);
                }
            }
        }
    }
}
