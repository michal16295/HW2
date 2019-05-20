package game.arena;

import game.enums.SnowSurface;
import game.enums.WeatherCondition;

/**
 * Winter Arena class
 * Represents an arena with friction of snow surface.
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class WinterArena extends Arena {

    /**
     * Ctor for winter arena
     *
     * @param length    arena length
     * @param surface   arena surface
     * @param condition weather condition
     */
    public WinterArena(double length, SnowSurface surface, WeatherCondition condition) {
        super(length, surface, condition);
    }

    /**
     * Default ctor
     */
    public WinterArena() {
        super();
    }
}
