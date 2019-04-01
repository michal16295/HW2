package game.arena;

import game.entities.IMobileEntity;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;
import utilities.ValidationUtils;

public class WinterArena implements IArena {
    private double length;
    private SnowSurface surface;
    private WeatherCondition condition;

    public WinterArena(double length, SnowSurface surface, WeatherCondition condition){
        this.setLength(length);
        this.setCondition(condition);
        this.setSurface(surface);
    }
    public WinterArena(WinterArena other){
        this.setLength(other.length);
        this.setCondition(other.condition);
        this.setSurface(other.surface);
    }

    private void setLength(double length){
        ValidationUtils.assertNotNegative(length);
        this.length = length;
    }
    private void setSurface(SnowSurface surface){
        ValidationUtils.assertNotNull(surface);
        this.surface = surface;
    }
    private void setCondition(WeatherCondition condition){
        ValidationUtils.assertNotNull(condition);
        this.condition = condition;
    }

    public SnowSurface getSurface() {
        return surface;
    }

    public double getLength(){
        return this.length;
    }

    public double getFriction(){
        return getSurface().getFriction();
    }

    public boolean isFinished(IMobileEntity me){
        return me.getLocation().getX() > getLength();
    }
}
