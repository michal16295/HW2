package game.entities.sportsman;

import game.arena.IArena;
import game.competition.Competitor;
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
public class WinterSportsman extends Sportsman implements Competitor {
    private Discipline discipline;
    private IArena arena;

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
    public WinterSportsman(String name, double age, Gender gender, Discipline discipline, double maxSpeed, double acceleration, IArena arena) {
        super(name, age, gender, maxSpeed, League.calcAccelerationBonus(age) + acceleration);
        this.setDiscipline(discipline);
        this.setArena(arena);
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
        while (!isFinished()) {
            move(arena.getFriction());
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
        setLocation(new Point(arena.getLength(), 0));
    }
}
