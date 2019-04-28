package game.arena;

import game.entities.IMobileEntity;

/**
 * Arena interface
 * Represents an arena.
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public interface IArena {
    double getFriction();
    boolean isFinished(IMobileEntity me);
    double getLength();
}
