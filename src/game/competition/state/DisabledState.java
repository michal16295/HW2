package game.competition.state;

import game.entities.sportsman.WinterSportsman;

public class DisabledState implements CompetitionState {

    private WinterSportsman sportsman;

    public DisabledState(WinterSportsman sportsman) {
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
