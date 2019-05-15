package game.competition;

/**
 * ski competition builder interface
 */
public interface SkiCompetitionBuilder {

    Competition getCompetition();

    void buildLeague();

    void buildGender();

    void buildDiscipline();


}
