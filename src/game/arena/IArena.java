package game.arena;

import game.entities.IMobileEntity;
import game.enums.WeatherCondition;

/**
 * Arena interface
 * Represents an arena.
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public interface IArena {
    /**
     * @return arena's friction
     */
    double getFriction();

    /**
     * @param me mobile entity / sportsman
     * @return if crossed the finish line
     */
    boolean isFinished(IMobileEntity me);

    /**
     * @return arena's length
     */
    double getLength();

    WeatherCondition getCondition();
}
