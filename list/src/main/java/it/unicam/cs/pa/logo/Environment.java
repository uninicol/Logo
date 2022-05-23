package it.unicam.cs.pa.logo;

import java.awt.*;
import java.util.Collection;

/**
 * Classe usata per rappresentare l'ambiente della tavola di disegno
 *
 * @param <C> le coordinate usate dal piano
 */
public interface Environment<C extends Coordinate, D extends Direction> {
    /**
     * Restituisce una collezione di tutti i segmenti nell'ambiente
     *
     * @return la collezione dei segmenti nell'ambiente
     */
    Collection<Segment<C>> getSegments();

    /**
     * Restituisce il cursore utilizzato
     *
     * @return il cursore
     */
    AbstractCursor<C, ? extends Direction> getCursor();

    /**
     * Restituisce la coordinata del punto home nel piano
     *
     * @return la coordinata del punto home
     */
    C getHome();

    /**
     * Restituice il colore dello sfondo
     *
     * @return il colore dello sfondo
     */
    Color getBackgroundColor();

    /**
     * Elimina tutti i tratti disegnati nel piano
     */
    void clearAll();

    /**
     * Traccia una linea nel piano
     *
     * @param segment la linea da inserire
     */
    void drawLine(Segment<C> segment);

    /**
     * Restituisce il punto di arrivo del segmento
     *
     * @param sourcePoint il punto di partenza
     * @param segment     il segmento
     * @return il punto di arrivo
     */
    C getEndPoint(C sourcePoint, Segment<C> segment);
}