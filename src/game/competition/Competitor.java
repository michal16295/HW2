package game.competition;

import game.competition.state.CompetitionState;
import game.entities.IMobileEntity;

/**
 * Competitor interface
 * Represents an competitor.
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public interface Competitor extends IMobileEntity, Runnable, Cloneable {
    void initRace();

    String getName();

    double getSpeed();

    double getMaxSpeed();

    boolean isFinished();

    void resetLocation();

    int getId();

    String getColor();

    void setColor(String color);

    void setAcceleration(double acceleration);

    void setRunning(boolean state);

    boolean isInjured();

    boolean isDisabled();

    void setState(CompetitionState state);

    CompetitionState getState();


}
