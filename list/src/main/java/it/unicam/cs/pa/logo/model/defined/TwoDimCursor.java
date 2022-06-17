package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Coordinate;
import it.unicam.cs.pa.logo.model.Cursor;
import it.unicam.cs.pa.logo.model.Direction;

import java.awt.*;
import java.util.Objects;

/**
 * Rappresenta un cursore in un piano a due dimensioni
 */
public class TwoDimCursor implements Cursor {

    private int size = 1;
    private Coordinate position;
    private Direction direction;
    private Color lineColor = Color.BLACK;
    private Color areaColor = Color.WHITE;
    private boolean plot = true;

    public TwoDimCursor(Coordinate position, Direction direction) {
        this.position = Objects.requireNonNull(position);
        this.direction = Objects.requireNonNull(direction);
    }

    @Override
    public final Coordinate getPosition() {
        return position;
    }

    @Override
    public void move(Coordinate position) {
        this.position = position;
    }

    @Override
    public final Direction getDirection() {
        return direction;
    }

    @Override
    public final void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public final Color getLineColor() {
        return lineColor;
    }

    @Override
    public final void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    @Override
    public final Color getAreaColor() {
        return areaColor;
    }

    @Override
    public final void setAreaColor(Color areaColor) {
        this.areaColor = areaColor;
    }

    @Override
    public final boolean isPlot() {
        return plot;
    }

    @Override
    public final void setPlot(boolean plot) {
        this.plot = plot;
    }

    @Override
    public final int getSize() {
        return size;
    }

    @Override
    public final void setSize(int size) {
        this.size = Math.max(size, 1);
    }
}