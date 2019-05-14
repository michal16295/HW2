package game.arena;

import game.entities.IMobileEntity;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;
import utilities.ValidationUtils;

/**
 * Summer Arena class
 * Represents an arena with friction of snow surface.
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class SummerArena extends Arena {

    public SummerArena(double length, SnowSurface surface, WeatherCondition condition){
        super(length, surface, condition);
    }

}
