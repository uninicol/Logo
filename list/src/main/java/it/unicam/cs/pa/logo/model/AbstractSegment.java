package it.unicam.cs.pa.logo.model;

import java.awt.*;

/**
 * Classe astratta per rappresentare un segmento base
 */
public abstract class AbstractSegment implements Segment {
    private final Point startPoint;
    private final Point endPoint;
    private final int size;
    private final Color color;

    protected AbstractSegment(Point startPoint, Point endPoint, Color color) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.color = color;
        this.size = 1;
    }

    protected AbstractSegment(Point startPoint, Point endPoint, Color color, int size) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.color = color;
        this.size = size;
    }

    @Override
    public final Color getColor() {
        return color;
    }

    @Override
    public final Point getStartPoint() {
        return startPoint;
    }

    @Override
    public final Point getEndPoint() {
        return endPoint;
    }

    @Override
    public final int getSize() {
        return size;
    }
}
