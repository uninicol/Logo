package it.unicam.cs.pa.logo;


import java.util.Map;

/**
 * Classe usata per modellare un punto di <code>Environment</code>
 */
public interface Coordinate {

    /**
     * Restituisce i valori che descrivono le coordinate
     *
     * @return i valori che descrivono le coordinate
     */
    Map<String, Integer> getCoordinateValues();

    /**
     * Restituisce la distaza tra un punto e un'altro
     *
     * @param c2 la coordinata
     * @return la distanza tra i due punti
     */
    int getDistanceFrom(Coordinate c2);
}