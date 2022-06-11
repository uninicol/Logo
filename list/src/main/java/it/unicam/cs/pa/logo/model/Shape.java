package it.unicam.cs.pa.logo.model;

import java.awt.*;
import java.util.List;

/**
 * Rappresenta una serie di segmenti che possono essere chiusi formando un'area chiusa
 *
 * @param <C> le coordinate
 */
public interface Shape<C extends Coordinate<C>> {

    /**
     * Restituisce i segmenti
     *
     * @return i segmenti
     */
    List<Segment<C>> getSegments();

    /**
     * Aggiunge un segmento
     *
     * @param segment un segmento
     */
    void add(Segment<C> segment);

    /**
     * Restituisce il punto di partenza
     *
     * @return il punto di partenza
     */
    C getStartPoint();

    /**
     * Restituisce il colore di riempimento
     *
     * @return il colore di riempimento
     */
    Color getBackgroundColor();

    /**
     * Imposta il colore di riempimento
     *
     * @param color il colore di riempimento
     */
    void setBackgroundColor(Color color);

    /**
     * Restituisce true se l'area è chiusa, false altrimenti
     *
     * @return true se l'area è chiusa, false altrimenti
     */
    boolean isClosed();

    /**
     * Restituisce il numero di segmenti che compongono l'area
     *
     * @return il numero di segmenti che compongono l'area
     */
    int numSegments();
}