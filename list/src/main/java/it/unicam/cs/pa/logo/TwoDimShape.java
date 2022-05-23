package it.unicam.cs.pa.logo;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class TwoDimShape implements Shape<TwoDimCoordinate> {

    private final List<Segment<TwoDimCoordinate>> segments = new LinkedList<>();
    private final TwoDimCoordinate startPoint;
    private Color backgroundColor = Color.WHITE;
    private boolean isClosed = false;

    public TwoDimShape(TwoDimCoordinate startPoint) {
        this.startPoint=startPoint;
    }

    public TwoDimShape(Segment<TwoDimCoordinate> segment) {
        this.segments.add(segment);
        this.startPoint = segments.get(0).getPoint1();
    }

    @Override
    public List<Segment<TwoDimCoordinate>> getSegments() {
        return segments;
    }

    @Override
    public void add(Segment<TwoDimCoordinate> segment) {
        segments.add(segment);
        if (segment.getPoint2().equals(startPoint)) isClosed=true;
    }

    @Override
    public TwoDimCoordinate getStartPoint() {
        return startPoint;
    }

    @Override
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(Color color) {
        this.backgroundColor=color;
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }
}
