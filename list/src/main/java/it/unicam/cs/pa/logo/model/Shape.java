package it.unicam.cs.pa.logo.model;

import java.awt.*;
import java.util.List;

/**
 * Rappresenta una serie di segmenti che possono essere chiusi formando un'area chiusa
 */
public interface Shape {

    /**
     * Restituisce i segmenti
     *
     * @return i segmenti
     */
    List<Segment> getSegments();

    /**
     * Restituisce il punto di partenza
     *
     * @return il punto di partenza
     */
    default Coordinate getStartPoint() {
        return getSegments().get(0).getStartPoint();
    }

    /**
     * Restituisce il punto di fine
     *
     * @return il punto di fine
     */
    default Coordinate getLastPoint() {
        return getSegments().get(getSegments().size() - 1).getEndPoint();
    }

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
     * Aggiunge un segmento
     *
     * @param segment un segmento
     */
    void add(Segment segment);

    /**
     * Restituisce il numero di segmenti che compongono l'area
     *
     * @return il numero di segmenti che compongono l'area
     */
    default int numSegments() {
        return getSegments().size();
    }
}