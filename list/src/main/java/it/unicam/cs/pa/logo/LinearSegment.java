package it.unicam.cs.pa.logo;

import java.util.function.BiFunction;

public class LinearSegment implements Segment<TwoDimCoordinate> {
    private final TwoDimCoordinate startPoint;
    private final TwoDimCoordinate endPoint;

    public LinearSegment(TwoDimCoordinate startPoint, TwoDimCoordinate endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public TwoDimCoordinate getPoint1() {
        return startPoint;
    }

    @Override
    public TwoDimCoordinate getPoint2() {
        return endPoint;
    }

    @Override
    public BiFunction<Integer, Integer, Integer> getShape() {
        return (x, y) ->
                ((x - getPoint1().xAxis())) / (getPoint2().xAxis() - getPoint1().xAxis())
                        - ((y - getPoint1().yAxis())) / (getPoint2().yAxis() - getPoint1().yAxis());
    }
}
