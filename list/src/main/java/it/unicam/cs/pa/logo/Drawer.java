package it.unicam.cs.pa.logo;

import java.util.function.Function;

/**
 * Questa interfaccia rappresenta un disegnatore che disegna su un piano ricava punti di un Environment
 */
public interface Drawer<E extends Environment<C, D>, C extends Coordinate<C>, D extends Direction> {

    /**
     * Restituisce l'environment su cui disegna
     *
     * @return l'environment su cui disegna
     */
    E getEnvironment();

    /**
     * Se il cursore è giù traccia una linea altrimenti si sposta
     *
     * @param function la funzione della linea
     * @param distance la distanza tra il punto di partenza e il punto di arrivo
     */
    void drawLine(Function<Integer, Integer> function, int distance);

    /**
     * Restituisce il punto di arrivo di un cursore percorrendo linearmente per una certa distanza
     *
     * @param distance la distanza da percorrere
     * @return il punto di arrivo
     */
    C getCoordinateFromDistance(int distance);
}
