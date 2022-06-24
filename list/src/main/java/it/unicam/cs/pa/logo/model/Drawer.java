package it.unicam.cs.pa.logo.model;

/**
 * Questa interfaccia rappresenta un disegnatore che disegna su un piano ricava punti di un Environment
 */
public interface Drawer {

    /**
     * Traccia una linea se la penna è giù
     *
     * @param segment     il segmento da disegnare
     * @return l'environment aggiornato
     */
    Environment drawLine(Segment segment);

    /**
     * Traccia una linea se la penna è giù
     *
     * @param length      la lunghezza del tratto
     * @return l'environment aggiornato
     */
    Environment drawLine(int length);
}
