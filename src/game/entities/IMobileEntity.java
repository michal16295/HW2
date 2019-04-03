package game.entities;

import utilities.Point;

/**
 * MobileEntity interface
 * Represents an mobile entity in the system with location
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public interface IMobileEntity {
    void move(double friction);
    Point getLocation();
}
