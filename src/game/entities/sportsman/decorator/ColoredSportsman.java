package game.entities.sportsman.decorator;

/**
 * Colored sportsman
 * Represents the colors of the competitor
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class ColoredSportsman extends WSDecorator {
    private String color;

    /**
     * Ctor for the color
     *
     * @param winterSportsman the competitor
     * @param color           the color
     */
    public ColoredSportsman(IWinterSportsman winterSportsman, String color) {
        super(winterSportsman);
        this.color = color;
    }

    /**
     * @return colors of the competitor
     */
    @Override
    public String getColor() {
        return super.getColor() + " " + this.color;
    }
}
