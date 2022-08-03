package it.unicam.cs.pa.logo.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta una serie di segmenti che possono essere chiusi formando un'area chiusa
 */
public class Polygon implements Closable {

    private final List<Segment> segments;
    private Color color;

    public Polygon(Color color) {
        this.segments = new ArrayList<>();
        this.color = color;
    }

    /**
     * Restituisce il colore di riempimento
     *
     * @return il colore di riempimento
     */
    public Color getBackgroundColor() {
        return color;
    }

    /**
     * Imposta il colore di riempimento
     *
     * @param color il colore di riempimento
     */
    public void setBackgroundColor(Color color) {
        this.color = color;
    }

    /**
     * Restituisce true se l'area è chiusa, false altrimenti
     *
     * @return true se l'area è chiusa, false altrimenti
     */
    public boolean isClosed() {
        Point2D firstPoint = segments.get(0).getP1();
        Point2D lastPoint = segments.get(segments.size() - 1).getP2();
        return firstPoint.equals(lastPoint);
    }

    /**
     * Aggiunge un segmento al poligono
     *
     * @param segment il segmento da inserire
     */
    public void addSegment(Segment segment) {
        segments.add(segment);
    }

    /**
     * Restituisce la lista di segmenti di cui il poligono è composto
     *
     * @return la lista di segmenti di cui il poligono è composto
     */
    public List<Segment> getSegments() {
        return segments;
    }

    /**
     * Restituisce il numero di segmenti di cui il poligono è composto
     *
     * @return il numero di segmenti di cui il poligono è composto
     */
    public int size() {
        return segments.size();
    }
}