package it.unicam.cs.pa.logo;


/**
 * Classe usata per modellare un punto di <code>Environment</code>
 */
public interface Coordinate<C extends Coordinate<C>> {

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

    /**
     * Restituisce la distaza tra un due punti
     *
     * @param c1 la coordinata di arrivo
     * @return la distanza tra i due punti
     */
    int getDistanceFrom(C c1);
}