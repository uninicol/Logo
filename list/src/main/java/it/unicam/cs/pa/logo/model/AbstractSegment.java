package it.unicam.cs.pa.logo.model;

import java.util.function.Function;

/**
 * Classe astratta per rappresentare un segmento base
 *
 * @param <C> le coordinate che definiranno il segmento
 */
public abstract class AbstractSegment<C extends Coordinate<C>> implements Segment<C> {
    private final C startPoint;
    private final C endPoint;
    private final int size;
    private final Function<Integer, Integer> function;

    protected AbstractSegment(C startPoint, C endPoint, Function<Integer, Integer> function) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.function = function;
        this.size = 1;
    }

    protected AbstractSegment(C startPoint, C endPoint, Function<Integer, Integer> function, int size) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.function = function;
        this.size = size;
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
