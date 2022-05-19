package it.unicam.cs.pa.logo;

/**
 * Classe usata per modellare un punto di <code>Environment</code>
 */
public interface Coordinate {

    /**TODO probabilmente eliminero il metodo
     * Verifica se la posizione è valida per il piano
     *
     * @return true se la posizione è valida
     */
    boolean isValid();

    /**
     * Restituisce la distaza tra un punto e un'altro
     *
     * @param c2 la coordinata
     * @return la distanza tra i due punti
     */
    int getDistanceFrom(Coordinate c2);


//    /**
//     * Restituisce la distanza tra un punto e un'altro secondo una funzione
//     * @param c2 la coordinata
//     * @param function la funzione che passa per i punti
//     * @return la distanza tra i due punti
//     */
//    int getDistanceFrom(Coordinate c2, BiFunction<Integer, Integer,Integer> function);
}