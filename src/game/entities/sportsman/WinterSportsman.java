package game.entities.sportsman;

import game.arena.IArena;
import game.competition.*;
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
    private CompetitionState state;
    private CompetitionState activeState;
    private CompetitionState completedState;
    private CompetitionState disabledState;
    private CompetitionState injuredState;
    private boolean isRunning;
    private boolean injured;
    private boolean disabled;
    private int distanceStoped;

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
    public WinterSportsman(int id,String name, double age, Gender gender, Discipline discipline, double maxSpeed, double acceleration, IArena arena) {
        super(id,name, age, gender, maxSpeed, League.calcAccelerationBonus(age) + acceleration);
        this.setDiscipline(discipline);
        this.setArena(arena);
        this.setRunning(false);
        this.setDisabled(false);
        this.setInjured(false);
        createStates();


    }
    public WinterSportsman(IArena arena){
        this.setDiscipline(Discipline.SLALOM);
        this.setArena(arena);
        this.setRunning(false);
        this.setDisabled(false);
        this.setInjured(false);
        this.activeState = new activeState(this);
        this.completedState = new completedState(this);
        this.disabledState = new disabledState(this);
        this.injuredState = new injuredState(this);
        this.state = activeState;

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
        resetLocation();
        setChanged();
        notifyObservers();
    }

    /**
     * Limits the sportsman location to be in cross line
     */
    public void resetLocation() {
        if(getLocation().getX() >= 700)
            setLocation(new Point(arena.getLength(), 0));
    }

    @Override
    public void setAcceleration(double acceleration) {
        super.setAcceleration(acceleration);
    }


    @Override
    public double getAcceleration() {
        return super.getAcceleration();
    }

    /**
     * state getter
     * @return competitor state
     */

    public CompetitionState getState() {
        return state;
    }


    public void setName(String name) {
        super.setName(name);
    }


    public void setAge(double age) {
        super.setAge(age);
    }

    public void setGender(Gender gender){
        super.setGender(gender);
    }

    public void setMaxSpeed(double speed){

    }

    /**
     * state setter
     * @param state competitor state
     */
    public void setState(CompetitionState state) {
        this.state = state;
    }
    public void moveCompetitor(){
        this.getState().moveCompetitor();
    }

    public IArena getArena() {
        return arena;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public boolean isInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public CompetitionState getActiveState() {
        return activeState;
    }

    public void setActiveState(CompetitionState activeState) {
        this.activeState = activeState;
    }

    public CompetitionState getCompletedState() {
        return completedState;
    }

    public void setCompletedState(CompetitionState completedState) {
        this.completedState = completedState;
    }

    public CompetitionState getDisabledState() {
        return disabledState;
    }

    public void setDisabledState(CompetitionState disabledState) {
        this.disabledState = disabledState;
    }

    public CompetitionState getInjuredState() {
        return injuredState;
    }

    public void setInjuredState(CompetitionState injuredState) {
        this.injuredState = injuredState;
    }

    public int getDistanceStoped() {
        return distanceStoped;
    }

    public void setDistanceStoped(int distanceStoped) {
        this.distanceStoped = distanceStoped;
    }

    public WinterSportsman clone() throws CloneNotSupportedException{

        WinterSportsman sportsman = (WinterSportsman)super.clone();
        sportsman.createStates();
        return sportsman;


    }

    private void createStates() {
        this.activeState = new activeState(this);
        this.completedState = new completedState(this);
        this.disabledState = new disabledState(this);
        this.injuredState = new injuredState(this);
        this.state = activeState;
    }
}
