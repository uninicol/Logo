package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Direction;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Objects;

/**
 * Rappresenta un cursore in un piano a due dimensioni
 */
public class Cursor {

    private int size = 1;
    private Point2D position;
    private Direction direction;
    private Color lineColor = Color.BLACK;
    private Color areaColor = Color.WHITE;
    private boolean plot = true;

    public Cursor(Point position, Direction direction) {
        this.position = Objects.requireNonNull(position);
        this.direction = Objects.requireNonNull(direction);
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
    public void move(Point2D position) {
        this.position = position;
    }

    /**
     * Restituisce la direzione corrente del cursore
     *
     * @return la direzione corrente del cursore
     */
    public final Direction getDirection() {
        return direction;
    }

    /**
     * Imposta la direzione del cursore
     *
     * @param direction la nuova direzione
     */
    public final void setDirection(Direction direction) {
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