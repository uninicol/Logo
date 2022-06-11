package it.unicam.cs.pa.logo.model;

import java.awt.*;

/**
 * Interfaccia usata per rappresentare un cursore in un piano
 */
public interface Cursor<C extends Coordinate<C>, D extends Direction<D>> {

    /**
     * Restituisce la posizione corrente del cursore
     *
     * @return la posizione corrente del cursore
     */
    C getPosition();

    /**
     * Muove il cursore verso una posizione
     *
     * @param position la posizione dove sopostarsi
     */
    void move(C position);

    /**
     * Restituisce la direzione corrente del cursore
     *
     * @return la direzione corrente del cursore
     */
    D getDirection();

    /**
     * Imposta la direzione del cursore
     *
     * @param direction la nuova direzione
     */
    void setDirection(D direction);

    /**
     * Restituisce il colore della prossima linea che verrà tracciata
     *
     * @return il colore della prossima linea che verrà tracciata
     */
    Color getLineColor();

    /**
     * Imposta il colore della prossima linea che verrà tracciata
     *
     * @param lineColor il nuovo colore della linea
     */
    void setLineColor(Color lineColor);

    /**
     * Restituisce il colore della prossima area chiusa che verrà tracciata
     *
     * @return il colore della prossima area chiusa che verrà tracciata
     */
    Color getAreaColor();

    /**
     * Imposta il colore della prossima area chiusa che verrà tracciata
     *
     * @param areaColor il nuovo colore della prossima area chiusa che verrà tracciata
     */
    void setAreaColor(Color areaColor);

    /**
     * Restituisce true se al prossimo movimento traccia una linea, false altrimenti
     *
     * @return true se al prossimo movimento traccia una linea, false altrimenti
     */
    boolean isPlot();

    /**
     * Imposta se al prossimo movimento il cursore traccia una linea
     *
     * @param plot se al prossimo movimento il cursore traccia una linea
     */
    void setPlot(boolean plot);

    /**
     * Restituisce la dimensione del tratto
     *
     * @return la dimensione del tratto
     */
    int getSize();

    /**
     * Imposta la dimensione del tratto, se è minore di uno non verrà cambiato
     *
     * @param size la nuova dimensione del tratto
     */
    void setSize(int size);
}
