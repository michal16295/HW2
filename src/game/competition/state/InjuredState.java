package game.competition.state;

import game.entities.sportsman.WinterSportsman;

public class InjuredState implements CompetitionState {

    private WinterSportsman sportsman;

    public InjuredState(WinterSportsman sportsman) {
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
