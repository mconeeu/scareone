package eu.mcone.scareone;

import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.core.exception.MotionCaptureNotDefinedException;
import eu.mcone.scareone.cmd.ScareOneCMD;
import eu.mcone.scareone.enums.Captures;
import eu.mcone.scareone.listeners.GeneralPlayerListener;
import eu.mcone.scareone.listeners.PlayerInteractListener;
import eu.mcone.scareone.listeners.PlayerMoveListener;
import eu.mcone.scareone.player.ScareOnePlayer;
import eu.mcone.scareone.util.JumpScareManager;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.world.CoreWorld;
import eu.mcone.gameapi.api.GamePlugin;
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

        sendConsoleMessage("§aLoad Captures...");
        loadAutoCaptures();

        sendConsoleMessage("§aRegistering Commands and Listeners...");
        registerCommands(
                new ScareOneCMD()
        );
        registerEvents(
                new PlayerMoveListener(),
                new GeneralPlayerListener(),
                new PlayerInteractListener()
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

    private static void loadAutoCaptures() {
        for (Captures capture : Captures.values()) {
                capture.getNpc().playMotionCapture(capture.getMotionCapture());
                CoreSystem.getInstance().getNpcManager().getMotionCaptureHandler().getMotionCaptureScheduler().addNpc(capture.getNpc());

        }
    }

    public ScareOnePlayer getScareOnePlayer(UUID uuid) {
        for (ScareOnePlayer kp : players) {
            if (kp.getCorePlayer().getUuid().equals(uuid)) {
                return kp;
            }
        }
        return null;
    }

    public ScareOnePlayer getScareOnePlayer(Player player) {
        for (ScareOnePlayer kp : players) {
            CorePlayer corePlayer = CoreSystem.getInstance().getCorePlayer(player);
            if (kp.getCorePlayer().equals(corePlayer)) {
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
