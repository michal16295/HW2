package game.competition;

import game.arena.Arena;
import game.arena.ArenaFactory;
import game.arena.WinterArena;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

public class MyBuilder implements SkiCompetitionBuilder {
    private Competition competition;
    public MyBuilder(Arena arena) {

        competition = new SkiCompetition(arena);

    }
    @Override
    public Competition getCompetition() {
        return competition;
    }

    @Override
    public void buildLeague() {
        competition.setLeague(League.JUNIOR);
    }

    @Override
    public void buildGender() {
        competition.setGender(Gender.FEMALE);
    }

    @Override
    public void buildDiscipline() {
        competition.setDiscipline(Discipline.SLALOM);
    }
}
