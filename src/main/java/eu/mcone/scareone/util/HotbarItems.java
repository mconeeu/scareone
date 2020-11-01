package eu.mcone.scareone.util;

import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class HotbarItems {

    public static final ItemStack COLLECT_ITEM = new ItemBuilder(Material.CHEST, 1, 8)
            .displayName("§3§lGesammelte Items §8» §7§oAlle gesammelten Items")
            .create();

    public static final ItemStack WORLD_ITEM = new ItemBuilder(Material.GRASS, 1, 8)
            .displayName("§3§lWelten §8» §7§oAlle Spiel Welten")
            .create();

}
