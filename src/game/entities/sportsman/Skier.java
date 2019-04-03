package game.entities.sportsman;

import game.enums.Discipline;
import game.enums.Gender;

/**
 * Skier class
 * Represents a competitor of winter sportsman
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class Skier extends WinterSportsman {
    /**
     * Ctor that creates a sportsman with parameters.
     * @param name the name of the sportsman
     * @param age the age of the sportsman
     * @param gender the gender of the sportsman
     * @param maxSpeed the maximum speed
     * @param acceleration the acceleration
     */
    public Skier(String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline){
        super(name, age, gender, discipline, maxSpeed, acceleration);
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + ' ' + getName();
    }

}
