package eu.mcone.scareone.enums;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.item.ItemBuilder;
import eu.mcone.scareone.ScareOne;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Material;

@Getter
public enum Levels {

    TUTORIAL("TUTORIAL", 0
            , CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("tutorial-start")
            , CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("tutorial-end")
            , new ItemBuilder(Material.TRIPWIRE_HOOK).displayName("§fTutorial")
            , Quest.TUTORIAL),

    LABYRINTH("LABYRINTH", 1
            , CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("labyrinth-start")
            , CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("labyrinth-end")
            , new ItemBuilder(Material.LEAVES).displayName("§fLabyrinth")
            , Quest.LABYRINTH),

    HOUSE("HOUSE", 2
            , CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("house-start")
            , CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("house-end")
            , new ItemBuilder(Material.WOOD).displayName("§fHaus")
            , Quest.HOUSE),

    UNDERGROUND("UNDERGROUND", 3
            , CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("underground-start")
            , CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("underground-end")
            , new ItemBuilder(Material.STONE).displayName("§fKeller")
            , Quest.UNDERGROUND),

    PYRAMIDE("PYRAMIDE", 4
            , CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("pyramide-start")
            , CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("pyramide-end")
            , new ItemBuilder(Material.SANDSTONE).displayName("§fPyramide")
            , Quest.PYRAMIDE);

    private final String name;
    private final Integer level;
    private final Location startLocation, endLocation;
    private final ItemBuilder item;
    private final Quest quest;

    Levels(String name, Integer level, Location startLocation, Location endLocation, ItemBuilder item, Quest quest) {
        this.level = level;
        this.name = name;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.item = item;
        this.quest = quest;
    }

}
