package it.unicam.cs.pa.logo.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Rappresenta un ambiente a due dimensioni
 */
public abstract class Environment<C extends Cursor<?>> {

    private final int width;
    private final int height;
    private final C cursor;
    private final List<Polygon> polygons;
    private Color backgroundColor = Color.WHITE;

    public Environment(int width, int height, C cursor, Supplier<List<Polygon>> polygonSupplier) {
        this.width = width;
        this.height = height;
        this.cursor = Objects.requireNonNull(cursor);
        this.cursor.moveTo(new Point(width / 2, height / 2));
        this.polygons = polygonSupplier.get();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    /**
     * Verifica se il punto è all'interno dell'environment
     *
     * @param x la coordinata x
     * @param y la coordinata y
     * @return true se il punto (x,y) è all'interno dell'environment, false altrimenti
     */
    public boolean contains(int x, int y) {
        return x >= 0 &&
                x <= width &&
                y >= 0 &&
                y <= height;
    }

    /**
     * Verifica se il punto è all'interno dell'environment
     *
     * @param point il punto
     * @return true se il punto è all'interno dell'environment, false altrimenti
     */
    public boolean contains(Point2D point) {
        return this.contains((int) point.getX(), (int) point.getY());
    }
}

