package game.entities;

import game.enums.League;
import utilities.Point;
import utilities.ValidationUtils;

public class MobileEntity extends Entity implements IMobileEntity {
    private double maxSpeed;
    private double acceleration;
    private double speed;

    public MobileEntity(double maxSpeed, double acceleration){
        this.setSpeed(0);
        this.setAcceleration(acceleration);
        this.setMaxSpeed(maxSpeed);
    }
    private void setMaxSpeed(double maxSpeed){
        ValidationUtils.assertNotNegative(maxSpeed);
        this.maxSpeed = maxSpeed;
    }
    private void setAcceleration(double acceleration){
        ValidationUtils.assertNotNegative(acceleration);
        this.acceleration = acceleration;
    }
    private void setSpeed(double speed){
        ValidationUtils.assertNotNegative(speed);
        if(speed >= maxSpeed)
            speed = maxSpeed;
        this.speed = speed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getSpeed() {
        return speed;
    }

    public void move(double friction){
        this.setSpeed(this.getSpeed() + ( 1 - friction) * getAcceleration());
        double x = this.getLocation().getX() + getSpeed();
        Point move = new Point(x,0);
        this.setLocation(move);
    }
}
