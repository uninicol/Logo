package it.unicam.cs.pa.logo;

import java.awt.*;
import java.util.List;

public class TwoDimEnvironment implements Environment<TwoDimCoordinate> {

    private final int length;
    private final int height;
    private final List<Segment<TwoDimCoordinate>> segments;
    private Color backgroundColor = Color.WHITE;

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
    public void drawSegment(Cursor cursor, TwoDimCoordinate c1, TwoDimCoordinate c2) {
        segments.add(new TwoDimSegment(c1, c2));
    }

    @Override
    public TwoDimCoordinate getHomePoint() {
        return new TwoDimCoordinate(length / 2, height / 2);
    }

    @Override
    public void clear() {
        segments.clear();
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

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
