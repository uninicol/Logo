package it.unicam.cs.pa.logo;

import java.awt.*;

/**
 * Classe usata per rappresentare un cursore in un piano
 */
public abstract class AbstractCursor<C extends Coordinate, D extends Direction> {
    private C position;
    private D direction;
    private Color lineColor = Color.BLACK;
    private Color areaColor = Color.WHITE;
    private boolean plot = false;

    public AbstractCursor(C position, D direction) {
        this.position = position;
        this.direction = direction;
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
}
