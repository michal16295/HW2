package game.arena;

import game.enums.SnowSurface;
import game.enums.WeatherCondition;

/**
 * Summer Arena class
 * Represents an arena with friction of snow surface.
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class SummerArena extends Arena {

    /**
     * Ctor for summer arena
     *
     * @param length    arena length
     * @param surface   arena surface
     * @param condition weather condition
     */
    public SummerArena(double length, SnowSurface surface, WeatherCondition condition) {
        super(length, surface, condition);
    }

}
