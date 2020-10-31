package eu.mcone.scareone.inventorys;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import org.bukkit.entity.Player;

public class LevelsInventory extends CoreInventory {

    public LevelsInventory(Player player) {
        super("§fScareOne-Welten", player, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);


        openInventory();
    }
}
