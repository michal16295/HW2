package game.competition.builder;

import game.competition.Competition;

/**
 * ski competition builder interface
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public interface SkiCompetitionBuilder {

    Competition getCompetition();

    void buildLeague();

    void buildGender();

    void buildDiscipline();


}
