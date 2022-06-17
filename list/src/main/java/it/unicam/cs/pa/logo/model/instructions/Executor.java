package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.model.Environment;

import java.util.LinkedList;

/**
 * Questa interfaccia rappresenta un esecutore che esegue comandi
 */
public interface Executor {

    /**
     * Esegue un comando
     *
     * @param command il nome del comando
     * @return l'environment aggiornato
     */
    Environment execute(String command);

    /**
     * Esegue uno script
     *
     * @param script lo script
     * @return l'environment aggiornato
     */
    Environment execute(LinkedList<String> script);
}
