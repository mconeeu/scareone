package eu.mcone.scareone.enums;

import eu.mcone.coresystem.api.bukkit.npc.entity.PlayerNpc;
import eu.mcone.scareone.ScareOne;
import lombok.Getter;
import org.bukkit.entity.NPC;

@Getter
public enum Captures {

    TUTORIAL("tutorial", "capture-tutorial"),
    LABYRINTH("labyrinth", "capture-labyrinth"),
    HOUSE("house", "capture-house"),
    UNDERGROUND("underground", "capture-underground"),
    PYRAMIDE("pyramide", "capture-pyramide");

    private final String npc;
    private final String motionCapture;

    Captures(String npc, String motionCapture) {
        this.npc = npc;
        this.motionCapture = motionCapture;
    }

    public PlayerNpc getNpc() {
        return (PlayerNpc) ScareOne.getInstance().getGameWorld().getNPC(npc);
    }
}
