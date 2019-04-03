package game.entities.sportsman;

import game.competition.Competitor;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import utilities.Point;
import utilities.ValidationUtils;

/**
 * Sportsman class
 * Represents a mobile entity
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class WinterSportsman extends Sportsman implements Competitor {
    private Discipline discipline;

    /**
     * Ctor that creates a sportsman with parameters.
     * @param name the name of the sportsman
     * @param age the age of the sportsman
     * @param gender the gender of the sportsman
     * @param discipline the discipline of the sportsman
     * @param maxSpeed the maximum speed
     * @param acceleration the acceleration
     */
    public WinterSportsman(String name, double age, Gender gender, Discipline discipline, double maxSpeed, double acceleration){
        super(name, age, gender, maxSpeed, League.calcAccelerationBonus(age) + acceleration);
        this.setDiscipline(discipline);
    }

    /**
     * Sets the discipline of the sportsman.
     * @param discipline the discipline
     */
    private void setDiscipline(Discipline discipline){
        ValidationUtils.assertNotNull(discipline);
        this.discipline = discipline;
    }

    /**
     * Returns the discipline of sportsman.
     * @return the discipline of sportsman
     */
    public Discipline getDiscipline(){
        return discipline;
    }

    /**
     * Sets the location to initial position (0,0).
     */
    public void initRace(){
        this.setLocation(new Point());
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + ' ' + getName();
    }
}
