package it.unicam.cs.pa.logo;

/**
 * Rappresenta un cursore in un piano a due dimensioni
 */
public class TwoDimCursor extends AbstractCursor<TwoDimCoordinate, TwoDimDirection> {
    public TwoDimCursor(TwoDimCoordinate position, TwoDimDirection direction) {
        super(position, direction);
    }
}