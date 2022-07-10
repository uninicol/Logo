package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un ambiente a due dimensioni
 */
public class Environment extends Rectangle {

    private final Cursor cursor;
    private final List<Shape> shapes;
    private Color backgroundColor = Color.WHITE;

    public Environment(int width, int height, Cursor cursor) {
        super(width, height, width, height);
        this.cursor = cursor;
        this.shapes = new ArrayList<>();
    }

    /**
     * Restituice il cursore
     *
     * @return il cursore
     */
    public Cursor getCursor() {
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
    public final List<Shape> getShapes() {
        return shapes;
    }

    /**
     * Restituisce la coordinata del punto home nel piano
     *
     * @return la coordinata del punto home
     */
    public Point getHome() {
        return new Point(width / 2, height / 2);
    }

    /**
     * Elimina tutti i tratti disegnati nel piano
     */
    public void clearAll() {
        getShapes().clear();
    }

    @Override
    public boolean contains(int x, int y) {
        return x >= 0 && x <= width
                && y >= 0 && y <= height;
    }
}

