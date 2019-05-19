package game.competition;

import game.entities.sportsman.WinterSportsman;

public class disabledState implements CompetitionState {
    private WinterSportsman sportsman;

    public disabledState(WinterSportsman sportsman) {
        this.sportsman = sportsman;
    }

    @Override
    public void moveCompetitor() {

    }

    @Override
    public String toString() {
        return "disabled";
    }
}
