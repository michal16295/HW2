package game.arena;

import game.entities.IMobileEntity;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;
import utilities.ValidationUtils;

/**
 * Winter Arena class
 * Represents an arena with friction of snow surface.
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class WinterArena implements IArena {
    private double length;
    private SnowSurface surface;
    private WeatherCondition condition;

    /**
     * Ctor with parameters of arena's length, the surface and weather condition.
     * @param length length of arena
     * @param surface the surface
     * @param condition the weather condition
     */
    public WinterArena(double length, SnowSurface surface, WeatherCondition condition){
        this.setLength(length);
        this.setCondition(condition);
        this.setSurface(surface);
    }

    /**
     * Copy Ctor - copies the arena from other winter arena.
     * @param other winter arena to copy from
     */
    public WinterArena(WinterArena other){
        ValidationUtils.assertNotNull(other);
        this.setLength(other.length);
        this.setCondition(other.condition);
        this.setSurface(other.surface);
    }

    /**
     * Sets the length of the arena.
     * @param length the length
     */
    private void setLength(double length){
        ValidationUtils.assertNotNegative(length);
        this.length = length;
    }

    /**
     * Sets the surface of the arena.
     * @param surface the surface
     */
    private void setSurface(SnowSurface surface){
        ValidationUtils.assertNotNull(surface);
        this.surface = surface;
    }

    /**
     * Sets the weather condition of the arena.
     * @param condition the weather condition
     */
    private void setCondition(WeatherCondition condition){
        ValidationUtils.assertNotNull(condition);
        this.condition = condition;
    }

    /**
     * Returns the arena's surface.
     * @return arena's surface
     */
    public SnowSurface getSurface() {
        return surface;
    }

    /**
     * Returns the arena's length.
     * @return arena's length
     */
    public double getLength(){
        return this.length;
    }

    /**
     * Returns the surface's friction.
     * @return surface's friction
     */
    public double getFriction(){
        return getSurface().getFriction();
    }

    /**
     * Check whether the entity has crossed the finish line.
     * @param me the entity
     * @return true if crossed, false otherwise
     */
    public boolean isFinished(IMobileEntity me){
        return me.getLocation().getX() >= getLength();
    }

    /**
     * @return arena's details
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + ' ' + getLength() + ' ' + getSurface() + ' ' + getFriction();
    }
}
