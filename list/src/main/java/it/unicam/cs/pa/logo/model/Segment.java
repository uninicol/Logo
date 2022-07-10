package it.unicam.cs.pa.logo.model;

import java.awt.*;

/**
 * Classe usata per rappresentare una linea su un piano avente un punto di partenza ed un punto di arrivo
 */
public interface Segment {

    /**
     * Ritorna il punto di partenza di un segmento
     *
     * @return il punto di partenza
     */
    Point getStartPoint();

    /**
     * Ritorna il punto di arrivo di un segmento
     *
     * @return il punto di arrivo
     */
    Point getEndPoint();

    /**
     * Restituisce lo spessore del segmento
     *
     * @return lo spessore del segmento
     */
    int getSize();

    /**
     * Restituisce il colore del segmento
     *
     * @return il colore del segmento
     */
    Color getColor();
}