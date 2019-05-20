package game.competition.builder;

import game.arena.Arena;
import game.competition.Competition;
import game.competition.SkiCompetition;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

/**
 * Builds the competition
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class MyBuilder implements SkiCompetitionBuilder {
    private Competition competition;

    /**
     * ctor
     *
     * @param arena setting the arena for the competition
     */
    public MyBuilder(Arena arena) {
        competition = new SkiCompetition(arena);
    }

    @Override
    /**
     * Getting the competition
     */
    public Competition getCompetition() {
        return competition;
    }

    @Override
    /**
     * setting the league
     */
    public void buildLeague() {
        competition.setLeague(League.JUNIOR);
    }

    @Override
    /**
     * setting the gender
     */
    public void buildGender() {
        competition.setGender(Gender.FEMALE);
    }

    @Override
    /**
     * setting the discipline
     */
    public void buildDiscipline() {
        competition.setDiscipline(Discipline.SLALOM);
    }
}
