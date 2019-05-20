package game.arena;

import game.enums.SnowSurface;
import game.enums.WeatherCondition;

/**
 * Factory method to create arena
 * getting a string : Winter or Summer and by that sting we'll creating arena by the type
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class ArenaFactory {

    /**
     * Creates arena according to the type
     *
     * @param newArenaType the arena type summer/winter
     * @param length       arena length
     * @param surface      arena surface
     * @param condition    weather condition
     * @return the arena
     */
    public static Arena makeArena(String newArenaType, double length, SnowSurface surface, WeatherCondition condition) {
        if (newArenaType.equals("Summer")) {
            return new SummerArena(length, surface, condition);
        } else if (newArenaType.equals("Winter")) {
            return new WinterArena(length, surface, condition);
        } else return null;
    }

    /**
     * @return default winter arena
     */
    public static Arena makeDefaultWinterArena() {
        return new WinterArena();
    }
}
