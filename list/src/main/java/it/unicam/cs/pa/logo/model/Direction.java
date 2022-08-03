package it.unicam.cs.pa.logo.model;

/**
 * Rappresenta la direzione del cursore nel piano
 */
public interface Direction {

    /**
     * Restituisce il valore della direzione
     *
     * @return il valore della direzione
     */
    double getValue();

    /**
     * Incrementa il valore della direzione
     *
     * @param num valore da incrementare
     */
    void increase(double num);

    /**
     * Decrementa il valore della direzione
     *
     * @param num valore da decrementare
     */
    default void decrease(double num) {
        increase(-num);
    }
}