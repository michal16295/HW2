package game.competition.builder;

import game.competition.Competition;

/**
 * Competition engineer
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class CompetitionEngineer {
    private SkiCompetitionBuilder builder;

    /**
     * ctor
     *
     * @param builder SkiCimpetitionBuilder
     */
    public CompetitionEngineer(SkiCompetitionBuilder builder) {
        this.builder = builder;
    }

    /**
     * getting the competition
     *
     * @return competition
     */
    public Competition getCompetition() {
        return builder.getCompetition();
    }

    /**
     * Building the competition
     */
    public void constructCompetition() {
        builder.buildDiscipline();
        builder.buildGender();
        builder.buildLeague();
    }
}
