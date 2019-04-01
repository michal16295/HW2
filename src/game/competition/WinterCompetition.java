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
            if(league.isInLeague(((WinterSportsman) competitor).getAge())){
                if(((WinterSportsman) competitor).getGender() == this.gender){
                    if(((WinterSportsman) competitor).getDiscipline() == this.discipline)
                        return true;
                }
            }
        }
        if(competitor instanceof Skier){
            if(league.isInLeague(((Skier) competitor).getAge())){
                if(((Skier) competitor).getGender() == this.gender){
                    if(((Skier) competitor).getDiscipline() == this.discipline)
                        return true;
                }
            }
        }
        if(competitor instanceof Snowboarder){
            if(league.isInLeague(((Snowboarder) competitor).getAge())){
                if(((Snowboarder) competitor).getGender() == this.gender){
                    if(((Snowboarder) competitor).getDiscipline() == this.discipline)
                        return true;
                }
            }
        }
        return false;
    }
}
