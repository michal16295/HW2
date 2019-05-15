package game.competition;

import game.arena.IArena;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

public interface CompetitionPlan {
    void setArena(IArena arena);

    void setMaxCompetitors(int maxCompetitors);

    void setDiscipline(Discipline discipline);

    void setLeague(League league);

    void setGender(Gender gender);


}