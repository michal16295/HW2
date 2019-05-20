package game.entities.sportsman.decorator;

/**
 * Speedy sportsman
 * Represents the acceleration of the competitor
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class SpeedySportsman extends WSDecorator {
    private double acceleration;

    /**
     * Ctor for the acceleration of the competitor
     *
     * @param winterSportsman the competitor
     * @param acceleration    the acceleration
     */
    public SpeedySportsman(IWinterSportsman winterSportsman, double acceleration) {
        super(winterSportsman);
        this.acceleration = acceleration;
    }

    /**
     * @return sum of all accelerations
     */
    @Override
    public double getAcceleration() {
        return acceleration + super.getAcceleration();
    }
}
