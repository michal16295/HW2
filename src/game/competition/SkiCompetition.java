package game.competition;

import game.arena.IArena;
import game.entities.sportsman.Skier;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

public class SkiCompetition extends WinterCompetition {

    public SkiCompetition(IArena arena, int maxComp, Discipline discipline, League league, Gender gender){
        super(arena, maxComp, discipline, league, gender);
    }
    @Override
    public boolean isValidCompetitor(Competitor competitor) {
        return super.isValidCompetitor(competitor) && competitor instanceof Skier;
    }

}
