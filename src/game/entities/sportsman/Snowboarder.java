package game.entities.sportsman;

import game.arena.IArena;
import game.enums.Discipline;
import game.enums.Gender;

/**
 * Snowboarder class
 * Represents a competitor of winter sportsman
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class Snowboarder extends WinterSportsman {
    /**
     * Ctor that creates a sportsman with parameters.
     *
     * @param name         the name of the sportsman
     * @param age          the age of the sportsman
     * @param gender       the gender of the sportsman
     * @param maxSpeed     the maximum speed
     * @param acceleration the acceleration
     */
    public Snowboarder(int id, String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline, IArena arena) {
        super(id, name, age, gender, discipline, maxSpeed, acceleration, arena);
    }

    /**
     * Default ctor with arena only
     *
     * @param arena the arena
     */
    public Snowboarder(IArena arena) {
        super(arena);
    }

    /**
     * @return sportsman name
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + ' ' + getName();
    }

}
