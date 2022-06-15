package it.unicam.cs.pa.logo.model;


/**
 * Classe usata per modellare un punto di <code>Environment</code>
 */
public interface Coordinate {

    /**
     * Restituisce il punto dell'asse X
     *
     * @return il punto dell'asse X
     */
    int getX();

    /**
     * Restituisce il punto dell'asse Y
     *
     * @return il punto dell'asse Y
     */
    int getY();
}