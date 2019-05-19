package game.competition;

import game.entities.sportsman.WinterSportsman;

public class completedState implements CompetitionState {

    private WinterSportsman sportsman;

    public completedState(WinterSportsman sportsman) {
        this.sportsman = sportsman;
    }
    @Override
    public void moveCompetitor() {

    }

    @Override
    public String toString() {
        return "completed";
    }
}
