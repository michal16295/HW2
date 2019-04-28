package game.competition;

import game.entities.IMobileEntity;
import utilities.Point;

/**
 * Competitor interface
 * Represents an competitor.
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public interface Competitor extends IMobileEntity, Runnable{
    void initRace();
    double getSpeed();
    boolean isFinished();

    void resetLocation();
}
