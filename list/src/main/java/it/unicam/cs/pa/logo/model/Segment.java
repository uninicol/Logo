package it.unicam.cs.pa.logo.model;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Classe usata per rappresentare una linea su un piano
 */
public class Segment extends Line2D.Double {

    private final int size;
    private final Color color;

    public Segment(Point2D p1, Point2D p2, int size, Color color) {
        super(p1, p2);
        this.size = Math.max(size, 1);
        this.color = color;
    }

    public Segment(Point2D p1, Point2D p2, Color color) {
        super(p1, p2);
        this.size = 1;
        this.color = color;
    }

    public Segment(Point2D p1, Point2D p2, int size) {
        super(p1, p2);
        this.size = Math.max(size, 1);
        this.color = Color.BLACK;
    }

    public Segment(Point2D p1, Point2D p2) {
        super(p1, p2);
        this.size = 1;
        this.color = Color.BLACK;
    }

    /**
     * Restituisce lo spessore del segmento
     *
     * @return lo spessore del segmento
     */
    public final int getSize() {
        return size;
    }

    /**
     * Restituisce il colore del segmento
     *
     * @return il colore del segmento
     */
    public final Color getColor() {
        return color;
    }
}