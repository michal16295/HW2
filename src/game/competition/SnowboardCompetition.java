package game.competition;

import game.arena.IArena;
import game.entities.sportsman.Snowboarder;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

/**
 * Snowboard Competition class
 * Represents a Snowboard Competitor.
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class SnowboardCompetition extends WinterCompetition {

    /**
     * Ctor with parameters of arena, maxComp, discipline, league, gender
     *
     * @param arena      arena type
     * @param maxComp    maximum competitors in the game
     * @param discipline the discipline
     * @param league     league type
     * @param gender     MALE/FEMALE
     */
    public SnowboardCompetition(IArena arena, int maxComp, Discipline discipline, League league, Gender gender) {
        super(arena, maxComp, discipline, league, gender);
    }

    /**
     * Checks if the competitor is valid for the competition
     *
     * @param competitor the competitor
     * @return True if the competitor is valid and instance of Snowboarder
     */
    @Override
    public boolean isValidCompetitor(Competitor competitor) {
        return super.isValidCompetitor(competitor) && competitor instanceof Snowboarder;
    }
}
