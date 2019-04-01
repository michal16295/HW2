package game.entities.sportsman;

import game.competition.Competitor;
import game.enums.Discipline;
import game.enums.Gender;
import utilities.Point;
import utilities.ValidationUtils;

public class WinterSportsman extends Sportsman implements Competitor {
    private Discipline discipline;

    public WinterSportsman(String name, double age, Gender gender, Discipline discipline, double maxSpeed, double acceleration){
        super(name, age, gender, maxSpeed, acceleration);
        this.setDiscipline(discipline);
    }
    private void setDiscipline(Discipline discipline){
        ValidationUtils.assertNotNull(discipline);
        this.discipline = discipline;
    }
    public Discipline getDiscipline(){
        return discipline;
    }

    public void initRace(){
        this.setLocation(new Point());
    }
    @Override
    public String toString(){
        return getClass().getSimpleName() + ' ' + getName();
    }
}
