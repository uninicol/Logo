package it.unicam.cs.pa.logo;

import java.awt.*;
import java.util.Collection;

/**
 * Classe usata per rappresentare l'ambiente della tavola di disegno
 *
 * @param <C> le coordinate usate dal piano
 */
public interface Environment<C extends Coordinate> {
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


//
//
//    /**
//     * Restituisce il cursore usato nell'ambiente
//     *
//     * @return il cursore dell'ambiente
//     */
//    AbstractCursor getCursor();
//
//    /**
//     * Disegna una linea nell'ambiente
//     *
//     * @param cursor il cursore
//     * @param c1     la coordinata di partenza
//     * @param c2     la coordinata di arrivo
//     */
//    void drawSegment(Cursor cursor, C c1, C c2);
//
//    /**
//     * Restituisce il punto home
//     *
//     * @return il punto home
//     */
//    C getHomePoint();
//
//    /**
//     * Elimina i tratti disegnati
//     */
//    void clear();
//
//    /**
//     * Restituisce la coordinata dove il cursore finirà di disegnare
//     *
//     * @param sourcePoint il punto di partenza
//     * @return il punto di arrivo
//     */
//    Coordinate getPointOfArrival(Coordinate sourcePoint);
}