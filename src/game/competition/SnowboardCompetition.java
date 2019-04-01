package game.competition;

import game.arena.IArena;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

public class SnowboardCompetition extends WinterCompetition{

    public SnowboardCompetition(IArena arena, int maxComp, Discipline discipline, League league, Gender gender){
        super(arena, maxComp, discipline, league, gender);
    }
}
