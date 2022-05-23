package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.Coordinate;
import it.unicam.cs.pa.logo.Direction;
import it.unicam.cs.pa.logo.Environment;

import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * Questa interfaccia rappresenta un istruzione del linguaggio Logo
 *
 * @param <E> l'ambiente
 */
public interface Instruction<E extends Environment<? extends Coordinate,? extends Direction>> {

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
     * TODO da eliminare
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
    void execute(Deque<String> instruction);

    default Integer getAttribute(Deque<String> instructions){
        return Integer.parseInt(Objects.requireNonNull(instructions.poll()));
    }
}