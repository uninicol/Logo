package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.model.Environment;

import java.io.IOException;
import java.util.LinkedList;

public interface Executor <I extends Instruction>{
    /**
     * Esegue uno script di comandi definiti sul registro in un environment
     * @param registry il registro di comandi
     * @param environment l'environment
     * @param script lo script da eseguire
     * @return l'environment aggiornato
     */
    Environment execute(Registry<I> registry, Environment environment, LinkedList<String> script) throws IOException;
}
