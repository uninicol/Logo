package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionWriter;
import it.unicam.cs.pa.logo.model.Environment;

import java.util.Objects;
import java.util.Queue;

/**
 * Interfaccia che rappresenta un'istruzione
 */
public interface Instruction<E extends Environment<?>> extends InstructionWriter<E> {

    /**
     * Restituisce il risultato dell'applicazione dell'istruzione all'environment.
     *
     * @param script lo script contenente il comando
     * @return l'environment modificato dall'esecuzione
     */
    E apply(E environment, Queue<String> script);

    /**
     * Restituisce un attributo intero dallo script
     *
     * @param script lo script
     * @return un attributo intero per l'istruzione
     */
    default int getIntegerAttribute(Queue<String> script) {
        return Integer.parseInt(Objects.requireNonNull(script.poll()));
    }
}
