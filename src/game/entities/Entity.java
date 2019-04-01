package game.entities;

import utilities.Point;
import utilities.ValidationUtils;

public class Entity {
    private Point location;

    public Entity(){
        location = new Point(0,0);
    }
    public Entity(Point location){
        this.setLocation(location);
    }
    public void setLocation(Point location){
        ValidationUtils.assertNotNull(location);
        this.location = new Point(location);
    }
    public Point getLocation(){
        return this.location;
    }

}
