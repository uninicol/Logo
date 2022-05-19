package it.unicam.cs.pa.logo;

/**
 * Rappresenta delle coordinate su un piano a due dimensioni
 * @param xAxis punto asse x
 * @param yAxis punto asse y
 */
public record TwoDimCoordinate(int xAxis, int yAxis) implements Coordinate {
    public TwoDimCoordinate {
        if (!isValid()) throw new IllegalArgumentException();
    }

    @Override
    public boolean isValid() {
        return xAxis >= 0 && yAxis >= 0;
    }

    @Override
    public int getDistanceFrom(Coordinate c2) {
        return 0;
    }
}
