package it.unicam.cs.pa.logo;

/**
 * Un segmento rappresenta una linea da un punto di partenza a un punto di arrivo
 *
 * @param <C> le coordinate
 */
public abstract class Segment<C extends Coordinate> {//TODO: forse da fare extends Function

    private final C c1;
    private final C c2;

    public Segment(C c1, C c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    /**
     * punto di partenza di un segmento
     */
    C getPoint1() {
        return c1;
    }

    /**
     * punto di arrivo di un segmento
     */
    C getPoint2() {
        return c2;
    }
}