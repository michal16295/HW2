package game;

import game.arena.IArena;
import game.arena.WinterArena;
import game.competition.Competition;
import game.competition.Competitor;
import game.enums.*;

import java.lang.reflect.Constructor;

/**
 * Engine that runs the game step by step.
 */
public class GameEngine {
    private WinterArena arena;
    private Competition comp;
    private game.enums.Competition type;

    /**
     * Class singleton instance
     */
    private static GameEngine instance;

    /**
     * @return singleton instance of the game engine
     */
    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    /**
     * private empty Ctor for game engine
     */
    private GameEngine() {
    }

    public IArena getArena() {
        return arena;
    }

    public Competition getComp() {
        return comp;
    }

    public void setType(game.enums.Competition type) {
        this.type = type;
    }

    private String getPlayerType() {
        if (type == game.enums.Competition.Ski) return "game.entities.sportsman.Skier";
        return "game.entities.sportsman.Snowboarder";
    }

    public void buildArena(double len, SnowSurface surface, WeatherCondition weatherCondition) {
        arena = new WinterArena(len, surface, weatherCondition);
        comp = null;
    }

    public void buildCompetition(String type, int maxComp, Discipline discipline, League league, Gender gender) {
        try {
            Class aClass = getClass().getClassLoader().loadClass(type);
            Constructor ctor = aClass.getConstructor(IArena.class, int.class, Discipline.class, League.class, Gender.class);
            Object o = ctor.newInstance(arena, maxComp, discipline, league, gender);
            comp = (Competition) o;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Object createAndAddSportsman(String name, double age, double acceleration, double maxSpeed) throws IllegalStateException, IllegalArgumentException {
        Object o;
        try {
            String type = getPlayerType();
            Class aClass = getClass().getClassLoader().loadClass(type);
            Constructor ctor = aClass.getConstructor(String.class, double.class, Gender.class, double.class, double.class, Discipline.class, IArena.class);
            o = ctor.newInstance(name, age, comp.getGender(), acceleration, maxSpeed, comp.getDiscipline(), arena);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        comp.addCompetitor((Competitor) o);
        return o;
    }
}
