package game.competition.state;

import game.entities.sportsman.WinterSportsman;

/**
 * Active state
 * Moves the competitor till finish line
 * Or stops the competitor in case of injury or disable
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class ActiveState implements CompetitorState {

    private WinterSportsman sportsman;

    /**
     * Ctor
     *
     * @param sportsman the sportsman to apply the state
     */
    public ActiveState(WinterSportsman sportsman) {
        this.sportsman = sportsman;
    }

    /**
     * Moves the sportsman to finishline
     * Stops in case of injury or disable
     */
    @Override
    public void moveCompetitor() {
        sportsman.move(sportsman.getArena().getFriction());

        if (sportsman.isInjured() && sportsman.getDistanceStopped() <= sportsman.getLocation().getX()) {
            sportsman.setState(sportsman.getInjuredState());
            sportsman.setRunning(false);
        }
        if (sportsman.isDisabled() && sportsman.getDistanceStopped() <= sportsman.getLocation().getX()) {
            sportsman.setState(sportsman.getDisabledState());
            sportsman.setRunning(false);
        }
        if (sportsman.isFinished()) {
            sportsman.setState(sportsman.getCompletedState());
            sportsman.setRunning(false);
        }

    }

    /**
     * @return state name
     */
    @Override
    public String toString() {
        return "active";
    }
}
