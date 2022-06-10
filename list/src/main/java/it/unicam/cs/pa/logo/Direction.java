package it.unicam.cs.pa.logo;

/**
 * Rappresenta la direzione del cursore nel piano
 */
public interface Direction<D extends Direction<D>> {

    /**
     * Restituisce il valore della direzione
     *
     * @return il valore della direzione
     */
    Integer getValue();

    /**
     * Restituisce la direzione di default
     *
     * @return la direzione di default
     */
    D defaultDirection();
}