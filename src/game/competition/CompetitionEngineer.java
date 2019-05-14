package game.competition;

public class CompetitionEngineer {
    private SkiCompetitionBuilder builder;
    public CompetitionEngineer(SkiCompetitionBuilder builder){
        this.builder = builder;
    }
    public Competition getCompetition(){
        return builder.getCompetition();
    }
    public void constructCompetition(){
        builder.buildDiscipline();
        builder.buildGender();
        builder.buildLeague();
    }
}
