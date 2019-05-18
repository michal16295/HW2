package game;

import GUI.GuiManager;
import GUI.PanelGame;
import game.arena.ArenaFactory;
import game.arena.IArena;
import game.arena.Arena;
import game.competition.*;
import game.competition.Competition;
import game.entities.sportsman.Skier;
import game.enums.*;


import java.lang.reflect.Constructor;

/**
 * Engine that runs the game step by step.
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class GameEngine {
    private Arena arena;
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

    /**
     * @return the arena
     */
    public IArena getArena() {
        return arena;
    }

    /**
     * @return the competition
     */
    public Competition getComp() {
        return comp;
    }

    /**
     * Sets the competition type
     *
     * @param type the type ski or snowboard
     */
    public void setType(game.enums.Competition type) {
        this.type = type;
    }

    /**
     * Returns the player class based on competition type
     *
     * @return class name of sportsman
     */
    private String getPlayerType() {
        if (type == game.enums.Competition.Ski) return "game.entities.sportsman.Skier";
        return "game.entities.sportsman.Snowboarder";
    }

    /**
     * Builds an arena and nullify the competition
     *
     * @param len              arena length
     * @param surface          the surface
     * @param weatherCondition the weather condition
     */
    public void buildArena(String type,double len, SnowSurface surface, WeatherCondition weatherCondition) {
        arena = ArenaFactory.makeArena(type, len, surface, weatherCondition);
        comp = null;
    }

    /**
     * Builds the competition using reflection
     *
     * @param type       competition type ski or snowboard
     * @param maxComp    maximum competitors
     * @param discipline the discipline
     * @param league     the league
     * @param gender     the gender
     */
    public void buildCompetition(String type, int maxComp, Discipline discipline, League league, Gender gender) {
        try {
            String path = "game.competition.";
            String compClass = path + type + "Competition";
            Class aClass = getClass().getClassLoader().loadClass(compClass);
            Constructor ctor = aClass.getConstructor(IArena.class, int.class, Discipline.class, League.class, Gender.class);
            Object o = ctor.newInstance(arena, maxComp, discipline, league, gender);
            comp = (Competition) o;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Building a default competition using the builder Design Pattern
     */
    public void buildDefaultComp(){
        try{
            //Building the arena first
            this.arena = ArenaFactory.makeDefaultWinterArena();
            GuiManager.getPanelGame().setRatio(arena.getLength());
            //Building the competition - Ski competition
            SkiCompetitionBuilder cBuilder = new MyBuilder(arena);
            CompetitionEngineer engineer = new CompetitionEngineer(cBuilder);
            engineer.constructCompetition();
            comp = engineer.getCompetition();
            this.setType(game.enums.Competition.Ski);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * Creates a sportsman using reflection and adds to the competition
     *
     * @param name         sportsman name
     * @param age          sportsman age
     * @param acceleration sportsman acceleration
     * @param maxSpeed     sportsman max speed
     * @return the sportsman object
     * @throws IllegalStateException    Illegal competitor
     * @throws IllegalArgumentException Reached max competitors
     */
    public Object createAndAddSportsman(int id,String name, double age, double acceleration, double maxSpeed) throws IllegalStateException, IllegalArgumentException, IllegalAccessException {
        Object o;
        try {
            String type = getPlayerType();
            Class aClass = getClass().getClassLoader().loadClass(type);
            Constructor ctor = aClass.getConstructor(int.class,String.class, double.class, Gender.class, double.class, double.class, Discipline.class, IArena.class);
            o = ctor.newInstance(id,name, age, comp.getGender(), acceleration, maxSpeed, comp.getDiscipline(), arena);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        comp.addCompetitor((Competitor) o);
        return o;
    }

}
