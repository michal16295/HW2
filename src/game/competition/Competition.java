package game.competition;

import game.arena.IArena;
import utilities.ValidationUtils;

import java.util.ArrayList;
/**
 * Competition class
 * Represents an general competition.
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */

public abstract class Competition {
    private IArena arena;
    private int maxCompetitors;
    private ArrayList<Competitor> activeCompetitors;
    private ArrayList<Competitor> finishedCompetitors;

    /**
     * Ctor with parameters of arena and the max competitors in the competition.
     * @param arena competition arena
     * @param maxCompetitors number of maximum competitors
     */
    public Competition(IArena arena, int maxCompetitors){
        this.setArena(arena);
        this.setMaxCompetitors(maxCompetitors);
        activeCompetitors = new ArrayList<>();
        finishedCompetitors = new ArrayList<>();
    }

    /**
     * Sets the arena.
     * @param arena the length
     */
    private void setArena(IArena arena){
        ValidationUtils.assertNotNull(arena);
        this.arena = arena;
    }

    /**
     * Sets max competitors for the competition
     * @param maxCompetitors
     */
    private void setMaxCompetitors(int maxCompetitors){
        ValidationUtils.assertNotNegative(maxCompetitors);
        this.maxCompetitors = maxCompetitors;
    }

    /**
     * Add's a competitor to the competition
     * checks if the competition is not full  and if the competitor is valid to enter the competition
     * if TRUE inits the race and the competitor enters the competition
     * @param competitor
     */
    public void addCompetitor(Competitor competitor){
        ValidationUtils.assertNotNull(competitor);
        if(activeCompetitors.size() == maxCompetitors){
            throw new IllegalStateException("The Competition is full");
        }
        if(!isValidCompetitor(competitor)){
            throw new IllegalArgumentException("Invalid competitor " + competitor);
        }
        competitor.initRace();
        activeCompetitors.add(competitor);

    }

    /**
     * each active competitor makes a move
     * if the competitors finished the race - moves to the finished competitors list and removed from the active competitors list
     */
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

    /**
     * Returns the competition status
     * @return True if there is active competitors in the game
     */
    public boolean hasActiveCompetitors(){
        return activeCompetitors.size() > 0;
    }

    /**
     * Returns list of finished competitors
     * @return finished competitors list
     */
    public ArrayList<Competitor> getFinishedCompetitors(){
        return finishedCompetitors;
    }

    /**
     * Abstract function
     * @param competitor
     * @return
     */
    abstract protected boolean isValidCompetitor(Competitor competitor);

}
