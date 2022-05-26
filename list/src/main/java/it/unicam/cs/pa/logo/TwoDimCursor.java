package it.unicam.cs.pa.logo;

import java.awt.*;
import java.util.Objects;

/**
 * Rappresenta un cursore in un piano a due dimensioni
 */
public class TwoDimCursor implements Cursor<TwoDimCoordinate, TwoDimDirection> {

    private int size = 1;
    private TwoDimCoordinate position;
    private final TwoDimCoordinate angleLimit;
    private TwoDimDirection direction;
    private Color lineColor = Color.BLACK;
    private Color areaColor = Color.WHITE;
    private boolean plot = true;

    public TwoDimCursor(TwoDimCoordinate position, TwoDimCoordinate angleLimit, TwoDimDirection direction) {
        this.position = Objects.requireNonNull(position);
        this.angleLimit = Objects.requireNonNull(angleLimit);
        this.direction = Objects.requireNonNull(direction);
    }

    @Override
    public TwoDimCoordinate getPosition() {
        return position;
    }

    @Override
    public void move(TwoDimCoordinate position) {
        this.position = position;
    }

    @Override
    public TwoDimDirection getDirection() {
        return direction;
    }

    @Override
    public void setDirection(TwoDimDirection direction) {
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
    public TwoDimCoordinate getAngleLimit() {
        return angleLimit;
    }
}