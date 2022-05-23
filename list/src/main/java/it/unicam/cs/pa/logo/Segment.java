package it.unicam.cs.pa.logo;

import java.util.function.BiFunction;

/**
 * Classe usata per rappresentare una linea su un piano avente un punto di partenza ed un punto di arrivo
 *
 * @param <C> le coordinate
 */
public interface Segment<C extends Coordinate> {

    /**
     * Ritorna il punto di partenza di un segmento
     *
     * @return il punto di partenza
     */
    C getPoint1();

    /**
     * Ritorna il punto di arrivo di un segmento
     *
     * @return il punto di arrivo
     */
    C getPoint2();

    /**
     * Restituisce la funzione che rappresenta la linea
     *
     * @return la funzione che rappresenta la linea
     */
    BiFunction<Integer, Integer, Integer> getShape();
}