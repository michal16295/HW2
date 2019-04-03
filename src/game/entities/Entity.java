package game.entities;

import utilities.Point;
import utilities.ValidationUtils;

/**
 * Entity class
 * Represents an static entity in the system with location
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class Entity {
    private Point location;

    /**
     * Default Ctor - creates the entity at location (0,0)
     */
    public Entity(){
        location = new Point(0,0);
    }

    /**
     * Ctor with a location
     * @param location the location
     */
    public Entity(Point location){
        this.setLocation(location);
    }

    /**
     * Updates the current location of this entity
     * @param location new location
     */
    public void setLocation(Point location){
        ValidationUtils.assertNotNull(location);
        this.location = new Point(location);
    }

    /**
     * Returns the location this entity
     * @return current location
     */
    public Point getLocation(){
        return this.location;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + ' ' + getLocation();
    }

}
