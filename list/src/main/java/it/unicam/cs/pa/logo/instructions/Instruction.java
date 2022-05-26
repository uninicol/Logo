package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.Coordinate;
import it.unicam.cs.pa.logo.Direction;
import it.unicam.cs.pa.logo.Environment;

import java.util.Deque;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Questa interfaccia rappresenta un istruzione del linguaggio Logo
 *
 * @param <E> l'ambiente
 */
public interface Instruction<E extends Environment<? extends Coordinate, ? extends Direction>>
        extends Consumer<Deque<String>> {

    /**
     * Restituisce il numero di attributi che l'istruzione necessita
     *
     * @return il numero di attributi che l'istruzione necessita
     */
    int getRequiredAttributesNumber();

    /**
     * Restituisce l'ambiente su cui opera l'istruzione
     *
     * @return l'ambiente su cui opera l'istruzione
     */
    E getEnvironment();

    /**
     * Esegue il comando
     */
    void accept(Deque<String> instruction);

    default Integer getAttribute(Deque<String> instructions) {
        return Integer.parseInt(Objects.requireNonNull(instructions.poll()));
    }
}