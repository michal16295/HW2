package game.competition;

import game.entities.IMobileEntity;

/**
 * Competitor interface
 * Represents an competitor.
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public interface Competitor extends IMobileEntity, Runnable, Cloneable{
    void initRace();

    String getName();

    double getSpeed();

    double getMaxSpeed();

    boolean isFinished();

    void resetLocation();

    int getId();

    String getColor();

    void setId(int id);

    void setColor(String color);

    void setAcceleration(double acceleration);


}
