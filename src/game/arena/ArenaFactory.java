package game.arena;

import game.enums.SnowSurface;
import game.enums.WeatherCondition;

/**
 * Factory method to create arena
 * getting a string : Winter or Summer and by that sting we'll creating arena by the type
 */
public class ArenaFactory {

    public static Arena makeArena(String newArenaType, double length, SnowSurface surface, WeatherCondition condition){
        if(newArenaType.equals("Summer")){
            return new SummerArena(length, surface, condition);
        }else if(newArenaType.equals("Winter")){
            return new WinterArena(length, surface, condition);
        }else return null;
    }
    public static Arena makeDefaultWinterArena(){
        return new WinterArena();
    }
}
