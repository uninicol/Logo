package it.unicam.cs.pa.logo.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un ambiente a due dimensioni
 */
public class TwoDimEnvironment implements Environment<TwoDimCoordinate, TwoDimDirection> {
    private final int length;
    private final int height;
    /**
     * La lista di segmenti disegnati
     */
    private final List<Shape<TwoDimCoordinate>> shapes;
    private Color backgroundColor = Color.WHITE;
    private final TwoDimCursor cursor;

    public TwoDimEnvironment(int length, int height) {
        this.length = length;
        this.height = height;
        this.shapes = new ArrayList<>();
        cursor = new TwoDimCursor(getHome(), new TwoDimDirection());
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public List<Shape<TwoDimCoordinate>> getShapes() {
        return shapes;
    }

    @Override
    public TwoDimCursor getCursor() {
        return cursor;
    }

    @Override
    public TwoDimCoordinate getHome() {
        return new TwoDimCoordinate(length / 2, height / 2);
    }

    @Override
    public void clearAll() {
        shapes.clear();
    }
}

