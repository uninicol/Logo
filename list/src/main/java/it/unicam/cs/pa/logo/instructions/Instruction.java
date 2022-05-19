package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.AbstractCursor;
import it.unicam.cs.pa.logo.Coordinate;
import it.unicam.cs.pa.logo.Environment;

import java.util.Queue;
import java.util.function.BiConsumer;

/**
 * Questa interfaccia rappresenta un istruzione del linguaggio Logo
 */
public interface Instruction<S extends Queue<? extends String>, E extends Environment<? extends Coordinate>>
        extends BiConsumer<S, E> {//TODO non è function è string*env->null

    /**
     * Restituisce il nome del comando
     *
     * @return il nome del comando
     */
    String getInstructionName();

    /**
     * Restituisce il numero di attributi che l'istruzione necessita
     *
     * @return il numero di attributi che l'istruzione necessita
     */
    int getRequiredAttributesNumber();
}