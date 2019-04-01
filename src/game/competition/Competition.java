package game.competition;

import game.arena.IArena;
import utilities.ValidationUtils;

import java.util.ArrayList;

public abstract class Competition {
    private IArena arena;
    private int maxCompetitors;
    private ArrayList<Competitor> activeCompetitors;
    private ArrayList<Competitor> finishedCompetitors;

    public Competition(IArena arena, int maxCompetitors){
        this.setArena(arena);
        this.setMaxCompetitors(maxCompetitors);
        activeCompetitors = new ArrayList<>();
        finishedCompetitors = new ArrayList<>();
    }
    private void setArena(IArena arena){
        ValidationUtils.assertNotNull(arena);
        this.arena = arena;
    }
    private void setMaxCompetitors(int maxCompetitors){
        ValidationUtils.assertNotNegative(maxCompetitors);
        this.maxCompetitors = maxCompetitors;
    }
    public void addCompetitor(Competitor competitor){
        if(activeCompetitors.size() == maxCompetitors){
            throw new IllegalStateException("The Competition is full");
        }
        if(!isValidCompetitor(competitor)){
            throw new IllegalArgumentException("INVALID COMPETITOR");
        }
        competitor.initRace();
        activeCompetitors.add(competitor);

    }
    public void playTurn(){
        ArrayList<Competitor> temp = new ArrayList<>(activeCompetitors);
        for(Competitor i: temp){
            i.move(arena.getFriction());
            if(arena.isFinished(i)){
                activeCompetitors.remove(i);
                finishedCompetitors.add(i);
            }

        }
    }
    public boolean hasActiveCompetitors(){
        return activeCompetitors.size() > 0;
    }

    public ArrayList<Competitor> getFinishedCompetitors(){
        return finishedCompetitors;
    }

    abstract public boolean isValidCompetitor(Competitor competitor);

}
