package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.Coordinate;
import it.unicam.cs.pa.logo.Direction;
import it.unicam.cs.pa.logo.Environment;

import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Questa interfaccia rappresenta un istruzione del linguaggio Logo
 *
 * @param <E> l'ambiente
 */
public interface Instruction<E extends Environment<? extends Coordinate, ? extends Direction>>
        extends Consumer<LinkedList<String>> {

    /**
     * Restituisce il numero di attributi che l'istruzione necessita
     *
     * @return il numero di attributi che l'istruzione necessita
     */
    int getRequiredAttributesNumber();

    /**
     * Restituisce il numero di volte che sono stati richiesti gli attributi
     */
    int getCountRequestedAttributes();

    void setCountRequestedAttributes(int number);

    /**
     * Incrementa di uno il numero di attributi richiesti
     */
    default void incrementCountRequestedAttributes() {
        setCountRequestedAttributes(getCountRequestedAttributes() + 1);
    }

    /**
     * Restituisce l'ambiente su cui opera l'istruzione
     *
     * @return l'ambiente su cui opera l'istruzione
     */
    E getEnvironment();


    /**
     * Restituisce un attributo dall'istruzione
     *
     * @param instructions la coda di istruzioni
     * @return un attributo dall'istruzione
     */
    default Integer getAttribute(LinkedList<String> instructions) {
        incrementCountRequestedAttributes();
        if (getCountRequestedAttributes() > getRequiredAttributesNumber())
            throw new RuntimeException("Richiesti troppi attributi dall'istruzione");
        return Integer.parseInt(Objects.requireNonNull(instructions.poll()));
    }
}