package game.competition;

import game.arena.IArena;
import game.entities.sportsman.Skier;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

/**
 * Ski Competition class
 * Represents a ski competitor.
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class SkiCompetition extends WinterCompetition {

    /**
     * Ctor with parameters of arena, maxComp, discipline, league, gender
     *
     * @param arena      arena type
     * @param maxComp    maximum competitors in the game
     * @param discipline the discipline
     * @param league     league type
     * @param gender     MALE/FEMALE
     */
    public SkiCompetition(IArena arena, int maxComp, Discipline discipline, League league, Gender gender) {
        super(arena, maxComp, discipline, league, gender);
    }
    public SkiCompetition(IArena arena){
        super(arena);
    }

    /**
     * Checks if the competitor is valid for the competition
     *
     * @param competitor the competitor
     * @return True if the competitor is valid and instance of Skier
     */
    @Override
    public boolean isValidCompetitor(Competitor competitor) {
        return super.isValidCompetitor(competitor) && competitor instanceof Skier;
    }

}
