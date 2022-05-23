package it.unicam.cs.pa.logo;

import java.awt.*;

/**
 * Interfaccia usata per rappresentare un cursore in un piano
 */
public interface Cursor<C extends Coordinate, D extends Direction> {

    /**
     * Restituisce la posizione corrente del cursore
     *
     * @return la posizione corrente del cursore
     */
    C getPosition();

    void setPosition(C position);

    D getDirection();

    void setDirection(D direction);

    Color getLineColor();

    void setLineColor(Color lineColor);

    Color getAreaColor();

    void setAreaColor(Color areaColor);

    boolean isPlot();

    void setPlot(boolean plot);

    int getSize();

    void setSize(int size);
}
