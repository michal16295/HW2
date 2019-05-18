package game.entities.sportsman;

public class WSDecorator implements IWinterSportsman {
    protected IWinterSportsman winterSportsman;
    public WSDecorator(IWinterSportsman winterSportsman){
        this.winterSportsman = winterSportsman;
    }
    @Override
    public double getAcceleration() {
        return winterSportsman.getAcceleration();
    }

    @Override
    public String getColor() {
        return winterSportsman.getColor();
    }

    @Override
    public String getName() {
        return winterSportsman.getName();
    }
}
