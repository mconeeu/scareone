package eu.mcone.scareone.player;

import eu.mcone.coresystem.api.bukkit.player.profile.GameProfile;
import eu.mcone.scareone.enums.CollectItems;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class ScareOnePlayerProfile extends GameProfile {

    private int level;
    private ArrayList<CollectItems> item;

    ScareOnePlayerProfile(Player p, int level, ArrayList<CollectItems> item) {
        super(p);

        this.level = level;
        this.item = item;
    }

    @Override
    public void doSetData(Player player) {}

}
