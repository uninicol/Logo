package it.unicam.cs.pa.logo;

/**
 * Un segmento rappresenta una linea da un punto di partenza a un punto di arrivo
 *
 * @param <C> le coordinate
 */
public interface Segment<C extends Coordinate> {//TODO: forse da fare extends Function

    /**
     * punto di partenza di un segmento
     */
    C getPoint1();

    /**
     * punto di arrivo di un segmento
     */
    C getPoint2();
}