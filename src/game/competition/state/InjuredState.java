package game.competition.state;

import game.entities.sportsman.WinterSportsman;

/**
 * Disabled state
 * The state for disable the competitor
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class InjuredState implements CompetitorState {

    /**
     * Empty ctor as no need to change the state afterwards
     *
     * @param sportsman the sportsman
     */
    public InjuredState(WinterSportsman sportsman) {
    }

    /**
     * Does nothing as the competitor has been injured
     */
    @Override
    public void moveCompetitor() {

    }

    /**
     * @return state name
     */
    @Override
    public String toString() {
        return "injured";
    }
}
