package game.entities.sportsman;

import game.GameEngine;
import game.arena.IArena;
import game.competition.Competitor;
import game.competition.state.*;
import game.entities.sportsman.decorator.IWinterSportsman;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import utilities.Point;
import utilities.ValidationUtils;

/**
 * Sportsman class
 * Represents a mobile entity
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class WinterSportsman extends Sportsman implements Competitor, IWinterSportsman {
    private Discipline discipline;
    private IArena arena;
    private CompetitorState state;
    private CompetitorState activeState;
    private CompetitorState completedState;
    private CompetitorState disabledState;
    private CompetitorState injuredState;
    private boolean isRunning;
    private boolean injured;
    private boolean disabled;
    private int distanceStopped;
    private double time;

    /**
     * Ctor that creates a sportsman with parameters.
     *
     * @param name         the name of the sportsman
     * @param age          the age of the sportsman
     * @param gender       the gender of the sportsman
     * @param discipline   the discipline of the sportsman
     * @param maxSpeed     the maximum speed
     * @param acceleration the acceleration
     */
    public WinterSportsman(int id, String name, double age, Gender gender, Discipline discipline, double maxSpeed, double acceleration, IArena arena) {
        super(id, name, age, gender, maxSpeed, League.calcAccelerationBonus(age) + acceleration);
        this.setDiscipline(discipline);
        this.setArena(arena);
        this.setRunning(false);
        this.setDisabled(false);
        this.setInjured(false);
        createStates();
    }

    /**
     * Default ctor with arena only
     *
     * @param arena the arena
     */
    public WinterSportsman(IArena arena) {
        this.setDiscipline(Discipline.SLALOM);
        this.setArena(arena);
        this.setRunning(false);
        this.setDisabled(false);
        this.setInjured(false);
        createStates();
    }

    /**
     * Sets the discipline of the sportsman.
     *
     * @param discipline the discipline
     */
    private void setDiscipline(Discipline discipline) {
        ValidationUtils.assertNotNull(discipline);
        this.discipline = discipline;
    }

    /**
     * Returns the discipline of sportsman.
     *
     * @return the discipline of sportsman
     */
    public Discipline getDiscipline() {
        return discipline;
    }

    /**
     * Sets the location to initial position (0,0).
     */
    public void initRace() {
        this.setLocation(new Point());
        time = 0;
    }

    /**
     * @return weather the player crossed the finish line
     */
    @Override
    public boolean isFinished() {
        return arena.isFinished(this);
    }

    /**
     * Sets the arena that the player competes in
     *
     * @param arena the arena
     */
    public void setArena(IArena arena) {
        ValidationUtils.assertNotNull(arena);
        this.arena = arena;
    }

    /**
     * @return sportsman name
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + ' ' + getName();
    }

    /**
     * Makes a move until the finish line , with a delay of 100ms
     * Notify's the observer
     */
    @Override
    public void run() {
        while (isRunning()) {
            moveCompetitor();
            setChanged();
            notifyObservers();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        time = (System.currentTimeMillis() - GameEngine.getInstance().getComp().getStartTime()) / 1000.0;
        resetLocation();
        setChanged();
        notifyObservers();
    }

    /**
     * Limits the sportsman location to be in cross line
     */
    public void resetLocation() {
        if (getLocation().getX() >= arena.getLength())
            setLocation(new Point(arena.getLength(), 0));
    }

    /**
     * Sets the acceleration of the competitor
     *
     * @param acceleration the acceleration
     */
    @Override
    public void setAcceleration(double acceleration) {
        super.setAcceleration(acceleration);
    }


    /**
     * @return the acceleration of the competitor
     */
    @Override
    public double getAcceleration() {
        return super.getAcceleration();
    }

    /**
     * State getter
     *
     * @return competitor state
     */
    public CompetitorState getState() {
        return state;
    }

    /**
     * @return the stop time of competitor
     */
    @Override
    public double getTime() {
        return time;
    }

    /**
     * Sets competitors name
     *
     * @param name the name
     */
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * Sets competitor's age
     *
     * @param age the age
     */
    public void setAge(double age) {
        super.setAge(age);
    }

    /**
     * Sets competitor's gender
     *
     * @param gender the gender
     */
    public void setGender(Gender gender) {
        super.setGender(gender);
    }

    /**
     * State setter
     *
     * @param state competitor state
     */
    public void setState(CompetitorState state) {
        this.state = state;
    }

    /**
     * Moves the competitor
     */
    public void moveCompetitor() {
        this.getState().moveCompetitor();
    }

    /**
     * Gets the arena
     *
     * @return the arena
     */
    public IArena getArena() {
        return arena;
    }

    /**
     * @return weather the competitor is moving
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Sets the competitor moving state
     *
     * @param running moving (true) or stopped (false)
     */
    public void setRunning(boolean running) {
        isRunning = running;
    }

    /**
     * Weather will be injured in the future
     *
     * @return true if will be injured, false otherwise
     */
    public boolean isInjured() {
        return injured;
    }

    /**
     * Sets if will be injured in the future
     *
     * @param injured true if will be injured, false otherwise
     */
    public void setInjured(boolean injured) {
        this.injured = injured;
    }

    /**
     * Weather will be disabled in the future
     *
     * @return true if will be disabled, false otherwise
     */
    public boolean isDisabled() {
        return disabled;
    }

    /**
     * Sets if will be disabled in the future
     *
     * @param disabled true if will be disabled, false otherwise
     */
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * @return Completed state
     */
    public CompetitorState getCompletedState() {
        return completedState;
    }

    /**
     * @return Disabled state
     */
    public CompetitorState getDisabledState() {
        return disabledState;
    }

    /**
     * @return Injured state
     */
    public CompetitorState getInjuredState() {
        return injuredState;
    }

    /**
     * @return the distance where competitor stops
     */
    public int getDistanceStopped() {
        return distanceStopped;
    }

    /**
     * Sets the distance where the competitor stops (in case of disabled/injury)
     *
     * @param distanceStopped the distance measured in arena length
     */
    public void setDistanceStopped(int distanceStopped) {
        this.distanceStopped = distanceStopped;
    }

    /**
     * Makes a deep copy of the competitor
     *
     * @return a new object of winter sportsman
     * @throws CloneNotSupportedException
     */
    public WinterSportsman clone() throws CloneNotSupportedException {
        WinterSportsman sportsman = (WinterSportsman) super.clone();
        sportsman.createStates();
        return sportsman;
    }

    /**
     * Create the states and sets the current state to active
     */
    private void createStates() {
        this.activeState = new ActiveState(this);
        this.completedState = new CompletedState(this);
        this.disabledState = new DisabledState(this);
        this.injuredState = new InjuredState(this);
        this.state = activeState;
    }
}
