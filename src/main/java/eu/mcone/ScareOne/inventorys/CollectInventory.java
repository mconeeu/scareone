package eu.mcone.ScareOne.inventorys;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import org.bukkit.entity.Player;

public class CollectInventory extends CoreInventory {

    public CollectInventory(Player player) {
        super("", player, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);


        openInventory();
    }
}
