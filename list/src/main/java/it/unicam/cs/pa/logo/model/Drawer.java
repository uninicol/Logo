package it.unicam.cs.pa.logo.model;

/**
 * Questa interfaccia rappresenta un disegnatore
 */
public interface Drawer<T, E> {

    /**
     * Disegna qualcosa su un oggetto
     *
     * @param element l'elemento da disegnare
     * @return l'oggetto con l'elemento disegnato
     */
    E draw(T element);
}
