package it.unicam.cs.pa.logo;


import java.util.List;
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
    <C extends Coordinate> int getDistanceFrom(C c2);

    /**
     * Restituisce il punto di arrivo data una distanza e un cursore
     *
     * @param distance  la distanza da percorrere
     * @param cursor il cursore
     * @return il punto di arrivo
     */
    Coordinate getCoordinateFromDistance(int distance,
                                         AbstractCursor<? extends Coordinate, ? extends Direction> cursor);

    Coordinate getCoordinateFromDistance(int distance,
                                         Environment<? extends Coordinate> environment);
}