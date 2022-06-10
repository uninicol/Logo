package it.unicam.cs.pa.logo;

import java.awt.*;
import java.util.List;

/**
 * Classe usata per rappresentare l'ambiente della tavola di disegno
 *
 * @param <C> le coordinate usate dal piano
 */
public interface Environment<C extends Coordinate<C>, D extends Direction<D>> {
    /**
     * Restituisce una collezione di tutti i segmenti nell'ambiente
     *
     * @return la collezione dei segmenti nell'ambiente
     */
    List<Shape<C>> getShapes();

    /**
     * Restituisce il cursore utilizzato
     *
     * @return il cursore
     */
    Cursor<C, D> getCursor();

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
     * Imposta il colore dello sfondo
     *
     * @param backgroundColor il colore dello sfondo
     */
    void setBackgroundColor(Color backgroundColor);

    /**
     * Imposta il colore di background
     *
     * @param r il componente rosso
     * @param g il componente giallo
     * @param b il componente blu
     */
    default void setBackgroundColor(int r, int g, int b) {
        setBackgroundColor(new Color(r, g, b));
    }

    /**
     * Elimina tutti i tratti disegnati nel piano
     */
    void clearAll();
}