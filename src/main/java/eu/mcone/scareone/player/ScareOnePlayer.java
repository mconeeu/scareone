package eu.mcone.scareone.player;

import eu.mcone.scareone.ScareOne;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.player.plugin.GamePlayerInventory;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerDataProfile;
import eu.mcone.coresystem.api.bukkit.player.profile.PlayerInventoryProfile;

public class ScareOnePlayer extends GamePlayerInventory<PlayerInventoryProfile> {

    static {
        PlayerDataProfile.preventTeleport(true);
    }

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
        ScareOne.getInstance().saveGameProfile(new PlayerInventoryProfile(corePlayer.bukkit(), enderchest));
    }

    public void unregister() {
        ScareOne.getInstance().unregisterScareOnePlayer(this);
    }


}
