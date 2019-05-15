package game.competition;

import game.arena.Arena;
import game.arena.ArenaFactory;
import game.arena.WinterArena;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

/**
 * Builds the competition
 */
public class MyBuilder implements SkiCompetitionBuilder {
    private Competition competition;

    /**
     * ctor
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
