package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionReader;
import it.unicam.cs.pa.logo.model.Environment;

import java.util.Queue;

/**
 * Esegue le istruzioni di uno script da un set di istruzioni definite su un registry su un Environment
 *
 * @param <I> l'istruzione
 * @param <E> l'environment
 */
@FunctionalInterface
public interface Executor<I extends Instruction<E>, E extends Environment<?>> {

    /**
     * Esegue uno script di comandi definiti sul registro in un environment
     *
     * @param registry    il registro di comandi
     * @param environment l'environment
     * @param script      lo script da eseguire
     * @return l'environment aggiornato
     */
    E execute(InstructionReader<I> registry, E environment, Queue<String> script);
}
