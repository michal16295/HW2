package game;

import game.arena.IArena;
import game.arena.WinterArena;
import game.competition.Competition;
import game.entities.sportsman.WinterSportsman;

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
	public void setArena(WinterArena arena){
		this.arena = arena;

	}
	public IArena getArena(){
		return arena;
	}

	public void setComp(Competition comp) {
		this.comp = comp;
	}

	public Competition getComp() {
		return comp;
	}

	public void addSportsman(WinterSportsman sportsman){
		getComp().addCompetitor(sportsman);
	}
	public void setType(game.enums.Competition type){
		this.type = type;
	}
	public String getPlayerType(){
		if(type == game.enums.Competition.Ski) return "game.entities.sportsman.Skier";
		return "game.entities.sportsman.Snowboarder";

	}
}
