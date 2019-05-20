package game.competition.state;

import game.entities.sportsman.WinterSportsman;

/**
 * Completed state
 * The state for crossing the finish line
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class CompletedState implements CompetitorState {

    /**
     * Empty ctor as no need to change the state afterwards
     *
     * @param sportsman the sportsman
     */
    public CompletedState(WinterSportsman sportsman) {
    }

    /**
     * Does nothing as the competitor finished the race
     */
    @Override
    public void moveCompetitor() {

    }

    /**
     * @return state name
     */
    @Override
    public String toString() {
        return "completed";
    }
}
