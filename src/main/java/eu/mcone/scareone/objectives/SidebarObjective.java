package eu.mcone.scareone.objectives;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.gamemode.Gamemode;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.scoreboard.CoreSidebarObjectiveEntry;
import eu.mcone.coresystem.api.bukkit.stats.CoreStats;
import eu.mcone.gameapi.api.scoreboard.GameObjective;

public class SidebarObjective extends GameObjective {

    public SidebarObjective() {
        super("Ingame");
    }

    @Override
    protected void onGameObjectiveRegister(CorePlayer corePlayer, CoreSidebarObjectiveEntry entry) {
        entry.setScore(10, "");
        entry.setScore(9, CoreSystem.getInstance().getTranslationManager().get("scareone.scoreboard.2"));
        entry.setScore(8, CoreSystem.getInstance().getTranslationManager().get("scareone.scoreboard.3") + player.getStats(Gamemode.UNDEFINED, CoreStats.class).getKills());
        entry.setScore(7, "");
        entry.setScore(6, CoreSystem.getInstance().getTranslationManager().get("scareone.scoreboard.4"));
        entry.setScore(5, CoreSystem.getInstance().getTranslationManager().get("scareone.scoreboard.5") + player.getStats(Gamemode.UNDEFINED, CoreStats.class).getDeaths());
        entry.setScore(4, "");
        entry.setScore(3, CoreSystem.getInstance().getTranslationManager().get("scareone.scoreboard.6"));
        entry.setScore(2, CoreSystem.getInstance().getTranslationManager().get("scareone.scoreboard.7") + player.bukkit().getLevel());
        entry.setScore(1, "");
        entry.setScore(0, CoreSystem.getInstance().getTranslationManager().get("scareone.scoreboard.8"));
    }

    @Override
    protected void onGameObjectiveReload(CorePlayer corePlayer, CoreSidebarObjectiveEntry entry) {
        entry.setTitle(CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.1"));

        entry.setScore(9, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.3") + player.getStats(Gamemode.UNDEFINED, CoreStats.class).getKills());
        entry.setScore(5, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.5") + player.getStats(Gamemode.UNDEFINED, CoreStats.class).getDeaths());
        entry.setScore(2, CoreSystem.getInstance().getTranslationManager().get("knockit.scoreboard.7") + player.bukkit().getLevel());
    }
}
