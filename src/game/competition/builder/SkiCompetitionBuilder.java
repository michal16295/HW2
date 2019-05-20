package game.competition.builder;

import game.competition.Competition;

/**
 * ski competition builder interface
 */
public interface SkiCompetitionBuilder {

    Competition getCompetition();

    void buildLeague();

    void buildGender();

    void buildDiscipline();


}
