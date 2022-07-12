package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Environment;

/**
 * Questa interfaccia è usata per trasformare un'istruzione in una stringa
 */
@FunctionalInterface
public interface InstructionWriter<E extends Environment<?>> {

    /**
     * Restituisce la stringa che rappresenta l'istruzione
     *
     * @param environment l'environment su cui l'istruzione ha operato
     * @return la stringa che rappresenta l'istruzione
     */
    String stringOf(E environment);
}
