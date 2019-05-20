package game.competition.state;

import game.entities.sportsman.WinterSportsman;

/**
 * Disabled state
 * The state for disable the competitor
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class DisabledState implements CompetitorState {

    /**
     * Empty ctor as no need to change the state afterwards
     *
     * @param sportsman the sportsman
     */
    public DisabledState(WinterSportsman sportsman) {
    }

    /**
     * Does nothing as the competitor has been disabled
     */
    @Override
    public void moveCompetitor() {
    }

    /**
     * @return state name
     */
    @Override
    public String toString() {
        return "disabled";
    }
}
