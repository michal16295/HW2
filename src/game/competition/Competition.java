package game.competition;

import game.arena.IArena;
import game.competition.builder.CompetitionPlan;
import game.entities.sportsman.Sportsman;
import game.entities.sportsman.WinterSportsman;
import game.enums.Discipline;
import game.enums.Gender;
import utilities.ValidationUtils;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Competition class
 * Represents an general competition.
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */

public abstract class Competition implements CompetitionPlan {

    private IArena arena;
    private int maxCompetitors;
    private ArrayList<Competitor> activeCompetitors;
    private int maxThreads;
    private ExecutorService pool;

    /**
     * Ctor with parameters of arena and the max competitors in the competition.
     *
     * @param arena          competition arena
     * @param maxCompetitors number of maximum competitors
     */
    public Competition(IArena arena, int maxCompetitors, int maxThreads) throws IllegalArgumentException {
        this.setArena(arena);
        this.setMaxCompetitors(maxCompetitors);
        this.setMaxThreads(maxThreads);
        activeCompetitors = new ArrayList<>();
    }

    /**
     * Sets the arena.
     *
     * @param arena the length
     */
    public void setArena(IArena arena) {
        ValidationUtils.assertNotNull(arena);
        this.arena = arena;
    }

    /**
     * Sets max competitors for the competition
     *
     * @param maxCompetitors maximum competitors
     */
    public void setMaxCompetitors(int maxCompetitors) {
        ValidationUtils.assertNotNegative(maxCompetitors);
        this.maxCompetitors = maxCompetitors;
    }

    /**
     * Add's a competitor to the competition
     * checks if the competition is not full  and if the competitor is valid to enter the competition
     * if TRUE inits the race and the competitor enters the competition
     *
     * @param competitor the competitor to add
     */
    public void addCompetitor(Competitor competitor) throws IllegalAccessException {
        ValidationUtils.assertNotNull(competitor);
        if (activeCompetitors.size() == maxCompetitors) {
            throw new IllegalStateException("The Competition is full");
        }
        if (IdExists(competitor.getId())) {
            throw new IllegalAccessException("Id already exists");
        }
        if (!isValidCompetitor(competitor)) {
            throw new IllegalArgumentException("Invalid competitor " + competitor);
        }
        competitor.initRace();
        activeCompetitors.add(competitor);

    }

    /**
     * Returns the competition status
     *
     * @return True if there is active competitors in the game
     */
    public boolean hasActiveCompetitors() {
        return activeCompetitors.size() > 0;
    }

    /**
     * Abstract function
     *
     * @param competitor the sportsman
     * @return true if the competitor can join the competition, false otherwise
     */
    abstract protected boolean isValidCompetitor(Competitor competitor);

    /**
     * @return competition gender
     */
    abstract public Gender getGender();

    /**
     * @return competition disciple
     */
    abstract public Discipline getDiscipline();

    /**
     * Start race: creates thread for each competitor in the current competition
     * Adding each competitor to the Observer
     */
    public void startRace() {
        if (pool != null) {
            pool.shutdownNow();
        }
        pool = Executors.newFixedThreadPool(maxThreads);
        for (Competitor comp : activeCompetitors) {
            comp.setRunning(true);
            pool.execute(comp);
        }
    }

    /**
     * @return max competitors
     */
    public int getMaxCompetitors() {
        return maxCompetitors;
    }

    /**
     * cloning players
     *
     * @param oldId the id of the player we wish to make clones of
     * @param newId the new id for the new player
     * @param color the color of the new player
     * @return new competitor
     * @throws IllegalStateException      if there are no competitors
     * @throws IllegalAccessException     if player doesnt exists by the old id that was given
     * @throws CloneNotSupportedException clone exception
     */
    public Competitor cloneCompetitor(int oldId, int newId, String color) throws IllegalStateException, IllegalAccessException, CloneNotSupportedException {
        Competitor newCompetitor;
        if (!activeCompetitors.isEmpty()) {
            newCompetitor = ((WinterSportsman) getCompetitorById(oldId)).clone();
            if (!IdExists(newId)) {
                ((Sportsman) newCompetitor).upgrade(newId, color);
                addCompetitor(newCompetitor);
                return newCompetitor;
            } else throw new IllegalArgumentException("Id already exists");

        } else throw new IllegalStateException("There are no competitors");

    }

    /**
     * getting competitor by his id
     *
     * @param id id of the competitor
     * @return competitor
     * @throws IllegalAccessException if competitor doesnt exists
     */
    public Competitor getCompetitorById(int id) throws IllegalAccessException {
        for (Competitor i : activeCompetitors) {
            if (i.getId() == id) {
                return i;
            }
        }
        throw new IllegalAccessException("Id doesn't exists");
    }

    /**
     * checking if the id already exists
     *
     * @param id competitor id
     * @return TRUE/FALSE
     */
    public boolean IdExists(int id) {
        for (Competitor i : activeCompetitors) {
            if (i.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the active sportsman
     *
     * @return active sportsman
     */
    public ArrayList<Competitor> getActiveCompetitors() {
        return activeCompetitors;
    }

    /**
     * @return arena
     */
    public IArena getArena() {
        return arena;
    }

    /**
     * Choose for all competitors their state in the future randomly
     */
    public void destiny() {
        Random rand = new Random();
        for (Competitor comp : activeCompetitors) {
            WinterSportsman sportsman = (WinterSportsman) comp;
            int n = rand.nextInt(3);
            int distance = rand.nextInt((int) (getArena().getLength() - 1));
            if (n == 0) {
                sportsman.setInjured(true);
                sportsman.setDistanceStopped(distance);
            }
            if (n == 1) {
                sportsman.setDisabled(true);
                sportsman.setDistanceStopped(distance);
            }
        }
    }

    /**
     * Sets max threads for threadpool that will run the players
     *
     * @param maxThreads maximum threads to run at once
     * @throws IllegalArgumentException if the maxThreads in not between 1 to 10
     */
    private void setMaxThreads(int maxThreads) throws IllegalArgumentException {
        if (maxThreads < 1 || maxThreads > 10)
            throw new IllegalArgumentException("Number of threads allowed is between 1 to 10");
        this.maxThreads = maxThreads;
    }
}
