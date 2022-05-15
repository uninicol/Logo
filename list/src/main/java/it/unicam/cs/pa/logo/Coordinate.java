package it.unicam.cs.pa.logo;

/**
 * Rappresenta un generico punto nello spazio
 */
public interface Coordinate {

    /**
     * Restituisce le coordinate dell'home
     *
     * @return le coordinate dell'home
     */
    Coordinate defaultCoordinate();

    /**
     * Verifica se la posizione è valida per il piano
     *
     * @return true se la posizione è valida
     */
    boolean isValid();
}
