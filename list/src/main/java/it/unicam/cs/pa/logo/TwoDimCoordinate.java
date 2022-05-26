package it.unicam.cs.pa.logo;

import java.util.Map;

/**
 * Rappresenta delle coordinate su un piano a due dimensioni
 *
 * @param xAxis punto asse x
 * @param yAxis punto asse y
 */
public record TwoDimCoordinate(int xAxis, int yAxis) implements Coordinate {
    @Override
    public Map<String, Integer> getCoordinateValues() {
        return Map.of("x", xAxis, "y", yAxis);
    }

    @Override
    public int getDistanceFrom(Coordinate c1) {
        if (!(c1 instanceof TwoDimCoordinate)) throw new IllegalArgumentException();
        return (int) Math.sqrt(
                Math.pow(this.xAxis() - ((TwoDimCoordinate) c1).xAxis(), 2)
                        + Math.pow(this.yAxis() - ((TwoDimCoordinate) c1).yAxis(), 2)
        );
    }
}