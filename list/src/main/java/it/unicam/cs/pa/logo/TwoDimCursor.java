package it.unicam.cs.pa.logo;

public class TwoDimCursor<C extends Coordinate, D extends Direction> extends AbstractCursor<C, D> {
    public TwoDimCursor(C position, D direction) {
        super(position, direction);
    }
}