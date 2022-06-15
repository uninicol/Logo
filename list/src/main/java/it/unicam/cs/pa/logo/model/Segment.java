package it.unicam.cs.pa.logo.model;

import java.awt.*;
import java.util.function.Function;

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
    C getStartPoint();

    /**
     * Ritorna il punto di arrivo di un segmento
     *
     * @return il punto di arrivo
     */
    C getEndPoint();

    /**
     * Restituisce lo spessore del segmento
     *
     * @return lo spessore del segmento
     */
    int getSize();

    /**
     * Restituisce il colore del segmento
     * @return il colore del segmento
     */
    Color getColor();

    /**
     * Restituisce la funzione che rappresenta la linea
     *
     * @return la funzione che rappresenta la linea
     */
    Function<Integer, Integer> getFunction();
}