package game.competition;

import game.entities.sportsman.WinterSportsman;

public class activeState implements CompetitionState {
    private WinterSportsman sportsman;

    public activeState(WinterSportsman sportsman){
        this.sportsman = sportsman;
    }

    @Override
    public void moveCompetitor() {

        sportsman.move(sportsman.getArena().getFriction());
        if(sportsman.isInjured() && sportsman.getDistanceStoped() <= sportsman.getLocation().getX()){
            sportsman.setState(sportsman.getInjuredState());
            sportsman.setRunning(false);
        }
        if(sportsman.isDisabled() && sportsman.getDistanceStoped() <= sportsman.getLocation().getX()){
            sportsman.setState(sportsman.getDisabledState());
            sportsman.setRunning(false);
        }
        if(sportsman.isFinished()){
            sportsman.setState(sportsman.getCompletedState());
            sportsman.setRunning(false);
        }

    }

    @Override
    public String toString() {
        return "active";
    }
}
