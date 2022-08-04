package it.unicam.cs.pa.logo.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Rappresenta un ambiente a due dimensioni
 */
public abstract class Environment<C extends Cursor<?>> extends Rectangle {

    private final C cursor;
    private final List<Polygon> polygons;
    private Color backgroundColor = Color.WHITE;

    public Environment(int width, int height, C cursor) {
        super(width, height);
        this.cursor = Objects.requireNonNull(cursor);
        this.polygons = new ArrayList<>();
    }

    /**
     * Restituice il cursore
     *
     * @return il cursore
     */
    public final C getCursor() {
        return cursor;
    }

    /**
     * Restituice il colore dello sfondo
     *
     * @return il colore dello sfondo
     */
    public final Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Imposta il colore dello sfondo
     *
     * @param backgroundColor il colore dello sfondo
     */
    public final void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * Restituisce una collezione di tutti i segmenti nell'ambiente
     *
     * @return la collezione dei segmenti nell'ambiente
     */
    public final List<Polygon> getPolygons() {
        return polygons;
    }

    /**
     * Restituisce la coordinata del punto home nel piano
     *
     * @return la coordinata del punto home
     */
    public final Point2D getHome() {
        return new Point(width / 2, height / 2);
    }

    /**
     * Elimina tutti i tratti disegnati nel piano
     */
    public void clearAll() {
        getPolygons().clear();
    }
}

