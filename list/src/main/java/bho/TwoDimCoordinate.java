package bho;

import it.unicam.cs.pa.logo.Coordinate;

public class TwoDimCoordinate implements Coordinate {

    /**
     * Punto nell'asse x
     */
    private final int xAxis;

    /**
     * Punto nell'asse y
     */
    private final int yAxis;

    public TwoDimCoordinate() {
        this.xAxis = 0;
        this.yAxis = 0;
    }

    public TwoDimCoordinate(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    @Override
    public Coordinate defaultCoordinate() {
        return new TwoDimCoordinate(0, 0);
    }

    @Override
    public boolean isValid() {
        return xAxis >= 0 && yAxis >= 0;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }
}
