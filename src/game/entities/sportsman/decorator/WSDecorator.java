package game.entities.sportsman.decorator;

/**
 * Winter Sportsman Decorator
 * Represents the decorator pattern which allows to decorate the competitor
 * with colors and adding acceleration
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class WSDecorator implements IWinterSportsman {
    protected IWinterSportsman winterSportsman;

    /**
     * Ctor for competitor
     *
     * @param winterSportsman the competitor
     */
    public WSDecorator(IWinterSportsman winterSportsman) {
        this.winterSportsman = winterSportsman;
    }

    /**
     * @return original acceleration
     */
    @Override
    public double getAcceleration() {
        return winterSportsman.getAcceleration();
    }

    /**
     * @return original color
     */
    @Override
    public String getColor() {
        return winterSportsman.getColor();
    }

    /**
     * @return competitor's name
     */
    @Override
    public String getName() {
        return winterSportsman.getName();
    }
}
