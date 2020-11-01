package eu.mcone.scareone.inventorys;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.scareone.ScareOne;
import eu.mcone.scareone.enums.CollectItems;
import eu.mcone.scareone.player.ScareOnePlayer;
import org.bukkit.entity.Player;

public class CollectInventory extends CoreInventory {

    public CollectInventory(Player player) {
        super("§fDeine gesammelten Items", player, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);

        ScareOnePlayer scareOnePlayer = ScareOne.getInstance().getScareOnePlayer(player);
        int i = InventorySlot.ROW_2_SLOT_1;

        for (CollectItems item : CollectItems.values()) {
            if (scareOnePlayer.hasCollectItem(item)) {
                setItem(i, item.getItem());
            }
            i++;
        }

        openInventory();
    }
}
