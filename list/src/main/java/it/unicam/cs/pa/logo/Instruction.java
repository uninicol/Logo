package it.unicam.cs.pa.logo;

import java.util.function.Function;

/**
 * Questa interfaccia rappresenta un istruzione del linguaggio Logo
 */
public interface Instruction<S extends String, E extends Environment<? extends Coordinate>>
        extends Function<S, E> {

    /**
     * Restituisce il numero di attributi che l'istruzione necessita
     *
     * @return il numero di attributi che l'istruzione necessita
     */
    int getRequiredAttributesNumber();
}