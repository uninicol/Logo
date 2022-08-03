package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Cursor;

import java.awt.*;

public class SimpleCursor extends Cursor<Direction360> {
    public SimpleCursor(Point position, Direction360 direction) {
        super(position, direction);
    }
}
