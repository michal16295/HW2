package game.competition;

import game.entities.sportsman.WinterSportsman;

public class injuredState implements CompetitionState {
    private WinterSportsman sportsman;

    public injuredState(WinterSportsman sportsman) {
        this.sportsman = sportsman;
    }

    @Override
    public void moveCompetitor() {

    }

    @Override
    public String toString() {
        return "injured";
    }
}
