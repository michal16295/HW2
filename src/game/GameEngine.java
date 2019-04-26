package game;

import game.arena.WinterArena;
import game.competition.Competition;
import game.competition.Competitor;
import utilities.ValidationUtils;

/**
 * Engine that runs the game step by step.
 */
public class GameEngine {
	private WinterArena arena;

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
	public void setArena(WinterArena arena){
		this.arena = arena;

	}

}
