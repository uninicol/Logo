package it.unicam.cs.pa.logo.model;


/**
 * Classe usata per modellare un punto in uno spazio bidimensionale
 */
public interface Coordinate {

    /**
     * Restituisce il punto dell'asse X
     *
     * @return il punto dell'asse X
     */
    int getX();

    /**
     * Restituisce il punto dell'asse Y
     *
     * @return il punto dell'asse Y
     */
    int getY();

    /**
     * Restituisce la distanza tra due punti
     *
     * @param px la coordinata X
     * @param py la coordinata Y
     * @return la distanza tra due punti
     */
    default int distance(int px, int py) {
        px -= getX();
        py -= getY();
        return (int) Math.sqrt(px * px + py * py);
    }

    /**
     * la distanza tra due punti
     *
     * @param c1 la coordinata
     * @return la distanza tra due punti
     */
    default int distance(Coordinate c1) {
        return distance(c1.getX(), c1.getY());
    }

    /**
     * Restituisce le coordinate distanti verso una direzione
     *
     * @param distance  la distanza
     * @param direction la direzione
     * @return le coordinate distanti verso una direzione
     */
    Coordinate getCoordinateFromDistance(int distance, Direction direction);
}