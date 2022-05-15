package it.unicam.cs.pa.logo;

import java.awt.*;
import java.util.List;

//TODO probabilmente da eliminare
/**
 * Rappresenta le linee disegnate
 *
 * @param <C> le coordinate
 */
public abstract class Shape<C extends Coordinate> {

    /**
     * lista dei segmenti che formano una forma
     */
    private final List<Segment<C>> segments;

    private Color color = Color.WHITE;

    /**
     * Indica se la forma è chiusa o no
     */
    private boolean isClosed = false;

    public Shape(List<Segment<C>> lines) {
        this.segments = lines;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}