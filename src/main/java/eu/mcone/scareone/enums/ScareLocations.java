package eu.mcone.scareone.enums;

import eu.mcone.scareone.ScareOne;
import eu.mcone.coresystem.api.bukkit.CoreSystem;
import lombok.Getter;
import org.bukkit.Location;

@Getter
public enum ScareLocations {

    GATEWAY("GATEWAY", CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("gateway-")),
    JUMPSCARE("JUMPSCARE", CoreSystem.getInstance().getWorldManager().getWorld(ScareOne.getInstance().getGameWorld().bukkit()).getLocation("jumpscare-"));

    private final String name;
    private final Location location;

    ScareLocations(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}
