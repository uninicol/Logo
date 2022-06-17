package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Coordinate;
import it.unicam.cs.pa.logo.model.Direction;

/**
 * Rappresenta delle coordinate su un piano a due dimensioni
 *
 * @param xAxis punto asse x
 * @param yAxis punto asse y
 */
public record TwoDimCoordinate(int xAxis, int yAxis) implements Coordinate {

    @Override
    public final int getX() {
        return xAxis;
    }

    @Override
    public final int getY() {
        return yAxis;
    }

    @Override
    public Coordinate getCoordinateFromDistance(int distance, Direction direction) {
        int angle = direction.getValue();
        int x = (int) Math.ceil(
                getX() + distance * Math.cos(Math.toRadians(angle))
        );
        int y = (int) Math.ceil(
                getY() + distance * Math.sin(Math.toRadians(angle) * -1)
        );
        /*
        if (!(x < 0 || x > environment.getLength()) && !(y < 0 || y > environment.getHeight()))
            return new TwoDimCoordinate(x, y);
        else return checkCoordinate(x, y, angle, distance);
         */
        return new TwoDimCoordinate(x, y);
    }
}