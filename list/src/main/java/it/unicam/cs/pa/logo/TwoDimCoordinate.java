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
    public int getDistanceFrom(Coordinate c2) {
        int x = c2.getCoordinateValues().get("x");
        int y = c2.getCoordinateValues().get("y");
        int xDistance = this.xAxis() - Math.abs(x);
        int yDistance = this.yAxis() - Math.abs(y);
        return (int) Math.floor(//uso il teorema di pitagora
                Math.sqrt(
                        Math.pow(xDistance, 2) + Math.pow(yDistance, 2)
                )
        );
    }
}