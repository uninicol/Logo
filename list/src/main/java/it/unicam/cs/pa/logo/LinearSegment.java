package it.unicam.cs.pa.logo;

import java.util.function.Function;

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
    public Function<Integer, Integer> getShape() {
        return
                x -> (
                        (x - startPoint.xAxis()) / (endPoint.xAxis() - startPoint.xAxis())
                                * (endPoint.yAxis() - startPoint.yAxis())
                )
                        + startPoint.yAxis();
    }
}
