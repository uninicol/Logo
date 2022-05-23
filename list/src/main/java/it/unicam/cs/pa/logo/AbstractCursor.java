package it.unicam.cs.pa.logo;

import java.awt.*;
import java.util.Objects;

/**
 * Classe usata per rappresentare un cursore in un piano, formatta le linee che traccia
 */
public abstract class AbstractCursor<C extends Coordinate, D extends Direction> {

    private int size = 1;
    private C position;
    private D direction;
    private Color lineColor = Color.BLACK;
    private Color areaColor = Color.WHITE;
    private boolean plot = true;

    public AbstractCursor(C position, D direction) {
        this.position = Objects.requireNonNull(position);
        this.direction = Objects.requireNonNull(direction);
    }

    public C getPosition() {
        return position;
    }

    public void setPosition(C position) {
        this.position = position;
    }

    public D getDirection() {
        return direction;
    }

    public void setDirection(D direction) {
        this.direction = direction;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public Color getAreaColor() {
        return areaColor;
    }

    public void setAreaColor(Color areaColor) {
        this.areaColor = areaColor;
    }

    public boolean isPlot() {
        return plot;
    }

    public void setPlot(boolean plot) {
        this.plot = plot;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size < 1) return;
        this.size = size;
    }

    /**
     * Restituisce il punto di arrivo data una distanza e un cursore
     *
     * @param distance    la distanza da percorrere
     * @return il punto di arrivo
     */
    public abstract C getCoordinateFromDistance(int distance);
}
