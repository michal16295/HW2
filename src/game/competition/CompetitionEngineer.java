package game.competition;

/**
 * Competition engineer
 */
public class CompetitionEngineer {
    private SkiCompetitionBuilder builder;

    /**
     * ctor
     * @param builder SkiCimpetitionBuilder
     */
    public CompetitionEngineer(SkiCompetitionBuilder builder){
        this.builder = builder;
    }

    /**
     * getting the competition
     * @return competition
     */
    public Competition getCompetition(){
        return builder.getCompetition();
    }

    /**
     * Building the competition
     */
    public void constructCompetition(){
        builder.buildDiscipline();
        builder.buildGender();
        builder.buildLeague();
    }
}
