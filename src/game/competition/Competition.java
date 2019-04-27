package game.competition;

import game.arena.IArena;
import game.entities.sportsman.Sportsman;
import game.enums.Discipline;
import game.enums.Gender;
import utilities.ValidationUtils;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Competition class
 * Represents an general competition.
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */

public abstract class Competition implements Observer {
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

    abstract public Gender getGender();

    abstract public Discipline getDiscipline();


    /**
     * Start race: creates thread for each competitor in the current competition
     * Adding each competitor to the Observer
     */
    public void startRace(){
        for(Competitor comp: activeCompetitors){
            Sportsman sportsman = (Sportsman) comp;
            sportsman.addObserver(this);
            new Thread(comp).start();

        }
    }
    public int getMaxCompetitors(){
        return maxCompetitors;
    }

    @Override
    public synchronized void update(Observable o, Object arg){
        finishedCompetitors.add((Competitor)o);
        activeCompetitors.remove(o);
        o.deleteObserver(this);
    }

}
