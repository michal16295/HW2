package game.entities.sportsman;

public class SpeedySportsman extends  WSDecorator {
    private double accelaration;
    public SpeedySportsman(IWinterSportsman winterSportsman, double accelaration) {
        super(winterSportsman);
        this.accelaration = accelaration;
    }

    @Override
    public double getAcceleration() {
        return accelaration + super.getAcceleration();
    }
}
