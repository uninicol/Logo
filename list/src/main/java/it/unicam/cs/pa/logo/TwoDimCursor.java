package it.unicam.cs.pa.logo;

/**
 * Rappresenta un cursore in un piano a due dimensioni
 */
public class TwoDimCursor extends AbstractCursor<TwoDimCoordinate, TwoDimDirection> {
    public TwoDimCursor(TwoDimCoordinate position, TwoDimDirection direction) {
        super(position, direction);
    }

    @Override
    public TwoDimCoordinate getCoordinateFromDistance(int distance) {
        int angle = getDirection().getAngle();

        int x = (int) Math.ceil(
                getPosition().xAxis() + distance * Math.cos(Math.toRadians(angle))
        );
        int y = (int) Math.ceil(
                getPosition().yAxis() + distance * Math.sin(Math.toRadians(angle) * -1)
        );
        return new TwoDimCoordinate(x, y);
    }
}