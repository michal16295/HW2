package game.competition.state;

import game.entities.sportsman.WinterSportsman;

public class CompletedState implements CompetitionState {

    private WinterSportsman sportsman;

    public CompletedState(WinterSportsman sportsman) {
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
