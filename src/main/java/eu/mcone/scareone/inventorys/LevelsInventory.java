package eu.mcone.scareone.inventorys;

import eu.mcone.coresystem.api.bukkit.inventory.CoreInventory;
import eu.mcone.coresystem.api.bukkit.inventory.InventoryOption;
import eu.mcone.coresystem.api.bukkit.inventory.InventorySlot;
import eu.mcone.scareone.ScareOne;
import eu.mcone.scareone.enums.Levels;
import eu.mcone.scareone.player.ScareOnePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

public class LevelsInventory extends CoreInventory {

    public LevelsInventory(Player player) {
        super("§fScareOne-Welten", player, InventorySlot.ROW_3, InventoryOption.FILL_EMPTY_SLOTS);

        ScareOnePlayer scareOnePlayer = ScareOne.getInstance().getScareOnePlayer(player);
        int i = InventorySlot.ROW_2_SLOT_1;

        for (Levels levels : Levels.values()) {
            if (scareOnePlayer.getLevelAmount() == levels.getLevel()) {
                setItem(i, levels.getItem().lore("§cAktuelle Map").enchantment(Enchantment.DAMAGE_ALL, 1).itemFlags(ItemFlag.HIDE_ENCHANTS).create());
            } else {
                setItem(i, levels.getItem().create());
            }
            i++;
        }
        openInventory();
    }
}
