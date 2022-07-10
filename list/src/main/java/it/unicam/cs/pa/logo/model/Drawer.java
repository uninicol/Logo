package it.unicam.cs.pa.logo.model;

import it.unicam.cs.pa.logo.model.defined.Environment;

/**
 * Questa interfaccia rappresenta un disegnatore che disegna su un piano ricava punti di un Environment
 */
public interface Drawer<E extends Environment> {

    /**
     * Traccia una linea se la penna è giù
     *
     * @param segment     il segmento da disegnare
     * @param environment l'environment su cui disegnare
     * @return l'environment aggiornato
     */
    E drawLine(E environment, Segment segment);

    /**
     * Traccia una linea se la penna è giù
     *
     * @param length      la lunghezza del tratto
     * @param environment l'environment su cui disegnare
     * @return l'environment aggiornato
     */
    E drawLine(E environment, int length);
}
