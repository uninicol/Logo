package it.unicam.cs.pa.logo;

public record TwoDimCoordinate(int xAxis, int yAxis) implements Coordinate {
    public TwoDimCoordinate {
        if (!isValid()) throw new IllegalArgumentException();
    }

    @Override
    public Coordinate defaultCoordinate() {
        return new TwoDimCoordinate(0, 0);
    }

    @Override
    public boolean isValid() {
        return xAxis >= 0 && yAxis >= 0;
    }
}
