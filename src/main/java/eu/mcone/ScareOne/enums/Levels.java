package eu.mcone.ScareOne.enums;

import eu.mcone.ScareOne.ScareOne;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import lombok.Getter;
import org.bukkit.Location;

@Getter
public enum Levels {

    TUTORIAL("TUTORIAL", 0, CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("tutorial-start")),
    LABYRINTH("LABYRINTH", 1, CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("labyrinth-start")),
    HOUSE("HOUSE", 2, CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("house-start")),
    UNDERGROUND("UNDERGROUND", 3, CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("underground-start")),
    PYRAMIDE("PYRAMIDE", 4, CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("pyramide-start"));

    private final String name;
    private final Integer level;
    private final Location location;

    Levels(String name, Integer level, Location location) {
        this.level = level;
        this.name = name;
        this.location = location;
    }

}
