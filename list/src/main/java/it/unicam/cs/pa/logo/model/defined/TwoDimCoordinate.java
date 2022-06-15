package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Coordinate;

/**
 * Rappresenta delle coordinate su un piano a due dimensioni
 *
 * @param xAxis punto asse x
 * @param yAxis punto asse y
 */
public record TwoDimCoordinate(int xAxis, int yAxis) implements Coordinate {

    @Override
    public int getX() {
        return xAxis;
    }

    @Override
    public int getY() {
        return yAxis;
    }
}