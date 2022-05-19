package it.unicam.cs.pa.logo;

/**
 * Rappresenta delle coordinate su un piano a due dimensioni
 *
 * @param xAxis punto asse x
 * @param yAxis punto asse y
 */
public record TwoDimCoordinate(int xAxis, int yAxis) implements Coordinate {
    @Override
    public int getDistanceFrom(Coordinate c2) {
        return 0;
    }
}
