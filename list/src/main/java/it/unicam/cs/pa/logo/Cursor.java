package it.unicam.cs.pa.logo;

import java.awt.*;

/**
 * Interfaccia usata per rappresentare un cursore in un piano
 */
public interface Cursor {//TODO forse da rimuovere

    /**
     * Restituisce la posizione corrente del cursore
     *
     * @return la posizione corrente
     */
    Coordinate getPosition();

    /**
     * Restituisce l'angolo verso cui è puntato il cursore
     *
     * @return l'angolo verso cui è puntato il cursore
     */
    Direction getDirection();

    /**
     * Restituisce il colore del tratto
     *
     * @return il colore del tratto
     */
    Color getLineColor();

    /**
     * Restituisce il colore dell'area quando una serie di segmenti producono un'area chiusa
     *
     * @return il colore di un'area chiusa
     */
    Color getAreaColor();

    /**
     * Restituisce <code>true</code> se il cursore genera o meno un tracciato
     *
     * @return <code>true</code> se il cursore genera o meno un tracciato
     */
    boolean getPlot();
}
