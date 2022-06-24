package it.unicam.cs.pa.logo.model;

import java.awt.*;
import java.util.List;

/**
 * Classe usata per rappresentare l'ambiente della tavola di disegno
 */
public interface Environment {

    /**
     * Restituisce la lunghezza dell'ambiente
     *
     * @return la lunghezza dell'ambiente
     */
    int getLength();

    /**
     * Restituisce l'altezza dell'ambiente
     *
     * @return l'altezza dell'ambiente
     */
    int getHeight();

    /**
     * Restituisce una collezione di tutti i segmenti nell'ambiente
     *
     * @return la collezione dei segmenti nell'ambiente
     */
    List<Shape> getShapes();

    /**
     * Restituisce il cursore utilizzato
     *
     * @return il cursore
     */
    Cursor getCursor();

    /**
     * Restituisce la coordinata del punto home nel piano
     *
     * @return la coordinata del punto home
     */
    Coordinate getHome();

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
    default void clearAll() {
        getShapes().clear();
    }

    /**
     * Testa se una coordinata è all'interno dell'environment
     *
     * @param coordinate la coordinata da testare
     * @return true se la coordinata è all'interno all'interno dell'environment
     */
    boolean contains(Coordinate coordinate);
}