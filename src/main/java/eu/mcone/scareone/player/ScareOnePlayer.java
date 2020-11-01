package eu.mcone.scareone.player;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerInventory;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerDataProfile;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerInventoryProfile;
import eu.mcone.scareone.ScareOne;
import eu.mcone.scareone.enums.CollectItems;
import eu.mcone.scareone.enums.Levels;
import lombok.Getter;

import java.util.ArrayList;

public class ScareOnePlayer extends GamePlayerInventory<PlayerInventoryProfile> {

    static {
        PlayerDataProfile.preventTeleport(true);
    }

    @Getter
    private int levelAmount;
    @Getter
    private ArrayList<CollectItems> items;

    public ScareOnePlayer(CorePlayer player) {
        super(player);
        ScareOne.getInstance().registerScareOnePlayer(this);
    }

    @Override
    public PlayerInventoryProfile loadData() {
        return ScareOne.getInstance().loadGameProfile(corePlayer.bukkit(), PlayerInventoryProfile.class);
    }

    @Override
    public void saveData() {
        ScareOne.getInstance().saveGameProfile(new ScareOnePlayerProfile(corePlayer.bukkit(), levelAmount, items));
    }

    public void setLevel(int amount) {
        levelAmount = amount;
        saveData();
    }

    public Levels getLevel() {
        for (Levels levelMaps : Levels.values()) {
            if (levelMaps.getLevel() == levelAmount) {
                return levelMaps;
            }
        }
        return null;
    }

    public void addCollectItem(CollectItems item) {
        items.add(item);
    }

    public boolean hasCollectItem(CollectItems item) {
        return items.contains(item);
    }

    public void removeCollectItem(CollectItems item) {
        items.remove(item);
    }

    public void unregister() {
        ScareOne.getInstance().unregisterScareOnePlayer(this);
    }


}
