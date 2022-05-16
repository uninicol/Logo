package it.unicam.cs.pa.logo;

import java.util.List;

/**
 * Classe usata per tenere traccia delle linee disegnate
 *
 * @param <C> le coordinate
 */
public interface Environment<C extends Coordinate> {
    /**
     * Restituisce la lista di tutti i segmenti nell'ambiente
     *
     * @return la lista di segmenti nell'ambiente
     */
    List<Segment<C>> getSegments();

    /**
     * Disegna una linea nell'ambiente
     *
     * @param cursor il cursore
     * @param c1     la coordinata di partenza
     * @param c2     la coordinata di arrivo
     */
    void drawSegment(Cursor cursor, C c1, C c2);

    /**
     * Restituisce il punto home
     *
     * @return il punto home
     */
    C getHomePoint();

    /**
     * Elimina i tratti disegnati
     */
    void clear();
}