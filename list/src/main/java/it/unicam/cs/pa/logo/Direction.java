package it.unicam.cs.pa.logo;

import java.util.List;

/**
 * Rappresenta la direzione del cursore nel piano
 */
public interface Direction {
    /**
     * Restituisce la direzione corrente
     *
     * @return la direzione
     */
    Direction getDirection();

    /**
     * Restituisce la direzione di default
     *
     * @return la direzione di default
     */
    Direction defaultDirection();

    /**
     * Restituisce una lista di elementi che caratterizzano la direzione
     *
     * @return una lista di elementi che caratterizzano la direzione
     */
    List<Integer> getDirectionValues();
}
