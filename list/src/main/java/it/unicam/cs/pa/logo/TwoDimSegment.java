package it.unicam.cs.pa.logo;

public class TwoDimSegment extends Segment<TwoDimCoordinate>{

    public TwoDimSegment(TwoDimCoordinate c1, TwoDimCoordinate c2) {
        super(c1, c2);
    }

    @Override
    public TwoDimCoordinate getPoint1() {
        return null;
    }

    @Override
    public TwoDimCoordinate getPoint2() {
        return null;
    }
}
