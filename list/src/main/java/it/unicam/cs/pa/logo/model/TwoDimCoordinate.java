package it.unicam.cs.pa.logo.model;

/**
 * Rappresenta delle coordinate su un piano a due dimensioni
 *
 * @param xAxis punto asse x
 * @param yAxis punto asse y
 */
public record TwoDimCoordinate(int xAxis, int yAxis) implements Coordinate<TwoDimCoordinate> {

    @Override
    public int getX() {
        return xAxis;
    }

    @Override
    public int getY() {
        return yAxis;
    }

    @Override
    public int getDistanceFrom(TwoDimCoordinate c1) {
        return (int) Math.sqrt(
                Math.pow(this.xAxis() - (c1).xAxis(), 2)
                        + Math.pow(this.yAxis() - (c1).yAxis(), 2)
        );
    }
}