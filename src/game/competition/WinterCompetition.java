package game.competition;

import game.arena.IArena;
import game.entities.sportsman.WinterSportsman;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import utilities.ValidationUtils;
/**
 * Winter Competition class
 * Represents a Winter Competition.
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class WinterCompetition extends Competition {
    private Discipline discipline;
    private League league;
    private Gender gender;

    /**
     * Ctor with parameters of arena, max competition, discipline, league, gender
     * @param arena the arena type
     * @param maxComp max competitors in the game
     * @param discipline the discipline
     * @param league league type
     * @param gender MALE/FEMALE
     */
    public WinterCompetition(IArena arena, int maxComp, Discipline discipline, League league, Gender gender){
        super(arena, maxComp);
        this.setDiscipline(discipline);
        this.setGender(gender);
        this.setLeague(league);
    }

    /**
     * Sets the discipline type
     * @param discipline the discipline
     */
    private void setDiscipline(Discipline discipline){
        ValidationUtils.assertNotNull(discipline);
        this.discipline = discipline;
    }

    /**
     * Sets the league type
     * @param league the league
     */
    private void setLeague(League league){
        ValidationUtils.assertNotNull(league);
        this.league = league;
    }

    /**
     * Sets the gender
     * @param gender the gender MALE/FEMALE
     */
    private void setGender(Gender gender){
        this.gender = gender;
    }

    /**
     * Checks if the competitor is valid for the competition
     * @param competitor the competitor
     * @return True if the competitor is valid
     */
    @Override
    protected boolean isValidCompetitor(Competitor competitor) {
        if(competitor instanceof WinterSportsman){
            WinterSportsman comp = (WinterSportsman) competitor;
            if(league.isInLeague(comp.getAge())){
                if(comp.getGender() == this.gender){
                    if(comp.getDiscipline() == this.discipline)

                        return true;
                }
            }
        }
        return false;
    }
}
