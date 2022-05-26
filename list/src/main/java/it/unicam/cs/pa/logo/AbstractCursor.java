package it.unicam.cs.pa.logo;

import java.awt.*;
import java.util.Objects;

/**
 * Classe astratta usata per rappresentare un cursore in un piano
 */
public abstract class AbstractCursor<C extends Coordinate, D extends Direction> implements Cursor<C, D> {

    private int size = 1;
    private C position;
    private final C angleLimit;
    private D direction;
    private Color lineColor = Color.BLACK;
    private Color areaColor = Color.WHITE;
    private boolean plot = true;

    public AbstractCursor(C position, C angleLimit, D direction) {
        this.position = Objects.requireNonNull(position);
        this.angleLimit=Objects.requireNonNull(angleLimit);
        this.direction = Objects.requireNonNull(direction);
    }

    @Override
    public C getPosition() {
        return position;
    }

    @Override
    public void move(C position) {
        this.position = position;
    }

    @Override
    public D getDirection() {
        return direction;
    }

    @Override
    public void setDirection(D direction) {
        this.direction = direction;
    }

    @Override
    public Color getLineColor() {
        return lineColor;
    }

    @Override
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    @Override
    public Color getAreaColor() {
        return areaColor;
    }

    @Override
    public void setAreaColor(Color areaColor) {
        this.areaColor = areaColor;
    }

    @Override
    public boolean isPlot() {
        return plot;
    }

    @Override
    public void setPlot(boolean plot) {
        this.plot = plot;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        if (size > 1) this.size = size;
    }

    @Override
    public C getAngleLimit() {
        return angleLimit;
    }
}
