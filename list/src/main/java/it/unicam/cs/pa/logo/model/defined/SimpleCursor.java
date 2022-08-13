package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Cursor;

import java.awt.geom.Point2D;

public class SimpleCursor extends Cursor<Direction360> {
    public SimpleCursor(Point2D position, Direction360 direction) {
        super(position, direction);
    }

    public SimpleCursor(Direction360 direction) {
        super(direction);
    }

    public SimpleCursor() {
        super();
    }
}
