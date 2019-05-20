package game.competition.builder;

import game.arena.IArena;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

/**
 * Competition plan interface
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public interface CompetitionPlan {
    void setArena(IArena arena);

    void setMaxCompetitors(int maxCompetitors);

    void setDiscipline(Discipline discipline);

    void setLeague(League league);

    void setGender(Gender gender);


}
