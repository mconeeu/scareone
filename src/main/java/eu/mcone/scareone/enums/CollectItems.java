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
    CARD("Karte", 2, new ItemBuilder(Material.BEACON).displayName("§fKarte").create(), ScareOne.getInstance().getGameWorld().getBlockLocation("card"));

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
