package game.entities.sportsman;

public class ColoredSportsman extends WSDecorator {
    private String color;

    public ColoredSportsman(IWinterSportsman winterSportsman, String color) {
        super(winterSportsman);
        this.color = color;
    }

    @Override
    public String getColor() {
        return super.getColor() + " " + this.color;
    }
}
