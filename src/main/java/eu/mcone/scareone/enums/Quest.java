package eu.mcone.scareone.enums;

import lombok.Getter;

@Getter
public enum Quest {

    TUTORIAL(Levels.TUTORIAL, "text-1"),
    LABYRINTH(Levels.LABYRINTH, "text-2"),
    HOUSE(Levels.HOUSE, "text-3"),
    UNDERGROUND(Levels.UNDERGROUND, "text-4"),
    PYRAMIDE(Levels.PYRAMIDE, "text-5");


    private final Levels level;
    private final String text;

    Quest(Levels name, String text) {
        this.level = name;
        this.text = text;

    }
}
