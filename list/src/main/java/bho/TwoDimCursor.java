package bho;

import it.unicam.cs.pa.logo.Coordinate;
import it.unicam.cs.pa.logo.Cursor;
import it.unicam.cs.pa.logo.Direction;

import java.awt.*;

public class TwoDimCursor implements Cursor {

    @Override
    public Coordinate getPosition() {
        return null;
    }

    @Override
    public Direction getDirection() {
        return new Direction(0);
    }

    @Override
    public Color getLineColor() {
        return null;
    }

    @Override
    public Color getAreaColor() {
        return null;
    }

    @Override
    public boolean getPlot() {
        return false;
    }
}
