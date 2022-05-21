package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.Coordinate;
import it.unicam.cs.pa.logo.Environment;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Questa interfaccia rappresenta un istruzione del linguaggio Logo
 *
 * @param <E> l'ambiente
 */
public interface Instruction<E extends Environment<? extends Coordinate>> {
    /**
     * Restituisce il nome del comando
     *
     * @return il nome del comando
     */
    String getName();

    /**
     * Restituisce il numero di attributi che l'istruzione necessita
     *
     * @return il numero di attributi che l'istruzione necessita
     */
    int getRequiredAttributesNumber();

    /**
     * Restituisce l'ambiente su cui opera l'istruzione
     * @return l'ambiente su cui opera l'istruzione
     */
    E getEnvironment();

    /**
     * Restituisce gli attributi necessari per eseguire il comando
     *
     * @return gli attributi necessari per eseguire il comando
     */
    default List<Integer> getAttributes(Queue<String> instruction) {
        return Stream.generate(instruction::poll)
                .limit(getRequiredAttributesNumber())
                .filter(Objects::nonNull)
                .map(Integer::parseInt)
                .toList();
    }

    /**
     * Esegue il comando
     */
    void execute(List<Integer> instruction);
}