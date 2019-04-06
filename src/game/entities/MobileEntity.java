package game.entities;

import utilities.Point;
import utilities.ValidationUtils;

/**
 * MobileEntity class
 * Represents an mobile entity in the system
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public abstract class MobileEntity extends Entity implements IMobileEntity {
    private double maxSpeed;
    private double acceleration;
    private double speed;

    /**
     * Ctor with maximum speed and acceleration for this mobile
     * @param maxSpeed the max speed
     * @param acceleration the acceleration
     */
    public MobileEntity(double maxSpeed, double acceleration){
        this.setSpeed(0);
        this.setAcceleration(acceleration);
        this.setMaxSpeed(maxSpeed);
    }

    /**
     * Sets the max speed
     * @param maxSpeed the max speed
     */
    private void setMaxSpeed(double maxSpeed){
        ValidationUtils.assertNotNegative(maxSpeed);
        this.maxSpeed = maxSpeed;
    }

    /**
     * Sets the acceleration
     * @param acceleration the acceleration
     */
    private void setAcceleration(double acceleration){
        ValidationUtils.assertNotNegative(acceleration);
        this.acceleration = acceleration;
    }

    /**
     * Sets the speed
     * @param speed the speed
     */
    private void setSpeed(double speed){
        ValidationUtils.assertNotNegative(speed);
        if(speed >= maxSpeed)
            speed = maxSpeed;
        this.speed = speed;
    }

    /**
     * Returns the max speed
     * @return max speed
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Returns the acceleration
     * @return acceleration
     */
    public double getAcceleration() {
        return acceleration;
    }

    /**
     * Returns the current speed
     * @return the current speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Moves the entity.
     * First it calculates the speed using friction: speed + (1 - friction) * acceleration
     * Then updates the location according to new speed: location + speed
     * @param friction the friction of the surface
     */
    public void move(double friction){
        this.setSpeed(this.getSpeed() + ( 1 - friction) * getAcceleration());
        double x = this.getLocation().getX() + getSpeed();
        Point move = new Point(x,0);
        this.setLocation(move);
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + ' ' + getMaxSpeed() + ' ' + getAcceleration() + ' ' + getSpeed();
    }
}
