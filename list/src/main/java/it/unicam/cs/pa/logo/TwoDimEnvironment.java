package it.unicam.cs.pa.logo;

import java.awt.*;
import java.util.List;

/**
 * Rappresenta un ambiente a due dimensioni
 */
public class TwoDimEnvironment implements Environment<TwoDimCoordinate> {

    private final int length;
    private final int height;
    private final List<Segment<TwoDimCoordinate>> segments;
    private Color backgroundColor = Color.WHITE;
    private final TwoDimCursor cursor = this.getCursor();

    public TwoDimEnvironment(List<Segment<TwoDimCoordinate>> segments, int length, int height) {
        this.length = length;
        this.height = height;
        this.segments = segments;
    }

    @Override
    public List<Segment<TwoDimCoordinate>> getSegments() {
        return segments;
    }

    @Override
    public TwoDimCursor getCursor() {
        return cursor;
    }

    @Override
    public TwoDimCoordinate getHome() {
        return new TwoDimCoordinate(length / 2, height / 2);
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void clearAll() {
        segments.clear();
    }

    @Override
    public void drawLine(Segment<TwoDimCoordinate> segment) {
        segments.add(segment);
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
