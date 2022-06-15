package it.unicam.cs.pa.logo.model;

import java.awt.*;
import java.util.function.Function;

/**
 * Classe astratta per rappresentare un segmento base
 *
 * @param <C> le coordinate che definiranno il segmento
 */
public abstract class AbstractSegment<C extends Coordinate> implements Segment<C> {
    private final C startPoint;
    private final C endPoint;
    private final int size;
    private final Color color;
    private final Function<Integer, Integer> function;

    protected AbstractSegment(C startPoint, C endPoint, Color color, Function<Integer, Integer> function) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.color = color;
        this.function = function;
        this.size = 1;
    }

    protected AbstractSegment(C startPoint, C endPoint, Color color, Function<Integer, Integer> function, int size) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.color = color;
        this.function = function;
        this.size = size;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public C getStartPoint() {
        return startPoint;
    }

    @Override
    public C getEndPoint() {
        return endPoint;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Function<Integer, Integer> getFunction() {
        return function;
    }
}
