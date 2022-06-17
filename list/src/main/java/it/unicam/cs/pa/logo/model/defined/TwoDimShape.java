package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Coordinate;
import it.unicam.cs.pa.logo.model.Segment;
import it.unicam.cs.pa.logo.model.Shape;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Rappresenta una serie di segmenti bidimensionali che possono diventare un'area chiusa
 */
public class TwoDimShape implements Shape {

    private final List<Segment> segments = new LinkedList<>();
    private final Coordinate startPoint;
    private Color backgroundColor = Color.WHITE;
    private boolean isClosed = false;

    public TwoDimShape(Segment segment) {
        this.segments.add(segment);
        this.startPoint = segment.getStartPoint();
    }

    @Override
    public final List<Segment> getSegments() {
        return segments;
    }


    @Override
    public final Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public final void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    @Override
    public final boolean isClosed() {
        return isClosed;
    }

    @Override
    public void add(Segment segment) {
        segments.add(segment);
        if (segment.getEndPoint().equals(startPoint))
            isClosed = true;
    }
}
