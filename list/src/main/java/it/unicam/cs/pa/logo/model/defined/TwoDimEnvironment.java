package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Cursor;
import it.unicam.cs.pa.logo.model.Shape;
import it.unicam.cs.pa.logo.model.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un ambiente a due dimensioni
 */
public class TwoDimEnvironment implements Environment {

    private final int length;
    private final int height;
    private final List<Shape> shapes;
    private final Cursor cursor;
    private final Drawer drawer;
    private Color backgroundColor = Color.WHITE;

    public TwoDimEnvironment(int length, int height) {
        this.length = length;
        this.height = height;
        this.shapes = new ArrayList<>();
        this.cursor = new TwoDimCursor(getHome(), new TwoDimDirection());
        this.drawer = new TwoDimDrawer(this);
    }

    @Override
    public final int getLength() {
        return length;
    }

    @Override
    public final int getHeight() {
        return height;
    }

    @Override
    public final Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public final void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public Drawer getDrawer() {
        return drawer;
    }

    @Override
    public final List<Shape> getShapes() {
        return shapes;
    }

    @Override
    public final Cursor getCursor() {
        return cursor;
    }

    @Override
    public TwoDimCoordinate getHome() {
        return new TwoDimCoordinate(length / 2, height / 2);
    }

    @Override
    public boolean contains(Coordinate coordinate) {
        return coordinate.getX() >= 0
                && coordinate.getX() <= getLength()
                && coordinate.getY() >= 0
                && coordinate.getY() <= getHeight();
    }
}

