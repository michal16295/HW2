package game.competition;

import game.arena.IArena;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;
import game.entities.sportsman.WinterSportsman;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import utilities.ValidationUtils;

public class WinterCompetition extends Competition {
    private Discipline discipline;
    private League league;
    private Gender gender;

    public WinterCompetition(IArena arena, int maxComp, Discipline discipline, League league, Gender gender){
        super(arena, maxComp);
        this.setDiscipline(discipline);
        this.setGender(gender);
        this.setLeague(league);
    }

    private void setDiscipline(Discipline discipline){
        ValidationUtils.assertNotNull(discipline);
        this.discipline = discipline;
    }
    private void setLeague(League league){
        ValidationUtils.assertNotNull(league);
        this.league = league;
    }
    private void setGender(Gender gender){
        this.gender = gender;
    }

    @Override
    public boolean isValidCompetitor(Competitor competitor) {
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
