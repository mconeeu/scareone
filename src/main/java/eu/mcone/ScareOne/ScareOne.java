package eu.mcone.ScareOne;

import eu.mcone.ScareOne.cmd.ScareOneCMD;
import eu.mcone.ScareOne.listeners.GeneralPlayerListener;
import eu.mcone.ScareOne.listeners.PlayerMoveListener;
import eu.mcone.ScareOne.player.ScareOnePlayer;
import eu.mcone.ScareOne.util.JumpScareManager;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.gameapi.api.GamePlugin;
import eu.mcone.gameapi.api.player.GamePlayer;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class ScareOne extends GamePlugin {

    public ScareOne() {
        super(Gamemode.UNDEFINED, "scareone.prefix");
    }

    @Getter
    private static ScareOne instance;
    @Getter
    private List<ScareOnePlayer> players;
    @Getter
    private CoreWorld gameWorld;
    @Getter
    private JumpScareManager jumpScareManager;

    @Override
    public void onGameEnable() {
        instance = this;
        players = new ArrayList<>();
        gameWorld = CoreSystem.getInstance().getWorldManager().getWorld(getGameConfig().parseConfig().getGameWorld());

        sendConsoleMessage("§aRegistering Commands and Listeners...");
        registerCommands(
                new ScareOneCMD()
        );
        registerEvents(
                new PlayerMoveListener(),
                new GeneralPlayerListener()
        );

        sendConsoleMessage("§aVersion §f" + this.getDescription().getVersion() + "§a enabled...");
    }

    @Override
    public void onGameDisable() {
        for (ScareOnePlayer scareOnePlayer : getOnlineScareOnePlayers()) {
            scareOnePlayer.saveData();
        }

        sendConsoleMessage("§cPlugin disabled!");
    }

    public ScareOnePlayer getScareOnePlayer(UUID uuid) {
        for (ScareOnePlayer kp : players) {
            if (kp.getCorePlayer().getUuid().equals(uuid)) {
                return kp;
            }
        }
        return null;
    }

    public ScareOnePlayer getScareOnePlayer(String name) {
        for (ScareOnePlayer kp : players) {
            if (kp.getCorePlayer().getName().equals(name)) {
                return kp;
            }
        }
        return null;
    }

    public Collection<ScareOnePlayer> getOnlineScareOnePlayers() {
        return new ArrayList<>(players);
    }

    public void registerScareOnePlayer(ScareOnePlayer kp) {
        players.add(kp);
    }

    public void unregisterScareOnePlayer(ScareOnePlayer gp) {
        players.remove(gp);
    }


}
