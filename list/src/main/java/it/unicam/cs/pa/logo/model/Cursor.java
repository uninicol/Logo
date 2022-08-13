package it.unicam.cs.pa.logo.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Objects;

/**
 * Rappresenta un cursore in un piano a due dimensioni
 */
public abstract class Cursor<D extends Direction<?>> {

    private int size = 1;
    private Point2D position;
    private D direction;
    private Color lineColor = Color.BLACK;
    private Color areaColor = Color.WHITE;
    private boolean plot = true;

    public Cursor(Point2D position, D direction) {
        this.position = Objects.requireNonNull(position);
        this.direction = Objects.requireNonNull(direction);
    }

    public Cursor(D direction) {
        this.position = new Point();
        this.direction = Objects.requireNonNull(direction);
    }

    public Cursor() {

    }

    /**
     * Restituisce la posizione corrente del cursore
     *
     * @return la posizione corrente del cursore
     */
    public final Point2D getPosition() {
        return position;
    }

    /**
     * Muove il cursore verso una posizione
     *
     * @param position la posizione dove sopostarsi
     */
    public final void moveTo(Point2D position) {
        this.position = position;
    }

    /**
     * Restituisce la direzione corrente del cursore
     *
     * @return la direzione corrente del cursore
     */
    public final D getDirection() {
        return direction;
    }

    /**
     * Imposta la direzione del cursore
     *
     * @param direction la nuova direzione
     */
    public final void setDirection(D direction) {
        this.direction = direction;
    }

    /**
     * Restituisce il colore della prossima linea che verrà tracciata
     *
     * @return il colore della prossima linea che verrà tracciata
     */
    public final Color getLineColor() {
        return lineColor;
    }

    /**
     * Imposta il colore della prossima linea che verrà tracciata
     *
     * @param lineColor il nuovo colore della linea
     */
    public final void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    /**
     * Restituisce il colore della prossima area chiusa che verrà tracciata
     *
     * @return il colore della prossima area chiusa che verrà tracciata
     */
    public final Color getAreaColor() {
        return areaColor;
    }

    /**
     * Imposta il colore della prossima area chiusa che verrà tracciata
     *
     * @param areaColor il nuovo colore della prossima area chiusa che verrà tracciata
     */
    public final void setAreaColor(Color areaColor) {
        this.areaColor = areaColor;
    }

    /**
     * Restituisce true se al prossimo movimento traccia una linea, false altrimenti
     *
     * @return true se al prossimo movimento traccia una linea, false altrimenti
     */
    public final boolean isPlot() {
        return plot;
    }

    /**
     * Imposta se al prossimo movimento il cursore traccia una linea
     *
     * @param plot se al prossimo movimento il cursore traccia una linea
     */
    public final void setPlot(boolean plot) {
        this.plot = plot;
    }

    /**
     * Restituisce la dimensione del tratto
     *
     * @return la dimensione del tratto
     */
    public final int getSize() {
        return size;
    }

    /**
     * Imposta la dimensione del tratto, se è minore di uno non verrà cambiato
     *
     * @param size la nuova dimensione del tratto
     */
    public final void setSize(int size) {
        this.size = Math.max(size, 1);
    }
}