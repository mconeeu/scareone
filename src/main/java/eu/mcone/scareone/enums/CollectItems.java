package eu.mcone.scareone.enums;

import eu.mcone.scareone.ScareOne;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Getter
public enum CollectItems {

    GIFT("Geschenk", 1, new ItemBuilder(Material.BEACON).displayName("§fGeschenk").create(), ScareOne.getInstance().getGameWorld().getBlockLocation("gift")),
    SWORD("Schwert", 2, new ItemBuilder(Material.IRON_SWORD).displayName("§fSchwert").create(), ScareOne.getInstance().getGameWorld().getBlockLocation("schwert")),
    SPIDER_EYE("Spinnen Auge", 3, new ItemBuilder(Material.SPIDER_EYE).displayName("§fSpinnen Auge").create(), ScareOne.getInstance().getGameWorld().getBlockLocation("spider-eye")),
    FLOWER("Blume", 3, new ItemBuilder(Material.YELLOW_FLOWER).displayName("§fGelbe Blume").create(), ScareOne.getInstance().getGameWorld().getBlockLocation("flower")),
    CARD("Karte", 4, new ItemBuilder(Material.BEACON).displayName("§fKarte").create(), ScareOne.getInstance().getGameWorld().getBlockLocation("card"));

    private final String name;
    private final Integer id;
    private final ItemStack item;
    private final Location blockLocation;

     CollectItems(String name, Integer id, ItemStack item, Location blockLocation) {
        this.name = name;
        this.id = id;
        this.item = item;
        this.blockLocation = blockLocation;
    }
}
