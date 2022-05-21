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
        if (!(c2 instanceof TwoDimCoordinate)) throw new IllegalArgumentException("Tipo diverso di Coordinate");

        int x = c2.getCoordinateValues().get("x");
        int y = c2.getCoordinateValues().get("y");
        int xDistance = xAxis - Math.abs(x);
        int yDistance = yAxis - Math.abs(y);
        return (int) Math.floor(
                Math.sqrt(
                        Math.pow(xDistance, 2) + Math.pow(yDistance, 2)
                )
        );
    }

    @Override
    public Coordinate getCoordinateFromDistance(int distance,
                                                AbstractCursor<? extends Coordinate, ? extends Direction> cursor) {
        Direction direction = cursor.getDirection();
        if (!(direction instanceof TwoDimDirection)) throw new IllegalArgumentException("Tipo diverso di Direction");

        Coordinate position = cursor.getPosition();
        int angle = ((TwoDimDirection) direction).getAngle();
        int originX = position.getCoordinateValues().get("x");
        int originY = position.getCoordinateValues().get("y");

        int x = (int) Math.ceil(
                originX + distance * Math.cos(Math.toRadians(angle))
        );
        int y = (int) Math.ceil(
                originY + distance * Math.sin(Math.toRadians(angle) * -1)
        );
        return new TwoDimCoordinate(x, y);
    }
}