package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionWriter;
import it.unicam.cs.pa.logo.model.Environment;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Questa interfaccia rappresenta un istruzione del linguaggio Logo
 */
public interface Instruction {

    /**
     * Restituisce il numero di attributi che l'istruzione ha bisogno
     *
     * @return il numero di attributi che l'istruzione ha bisogno
     */
    int getRequiredAttributesNumber();

    /**
     * Restituisce il numero di attributi che l'istruzione ha richiesto
     *
     * @return il numero di attributi che l'istruzione ha richiesto
     */
    int getRequestedAttributesNumber();

    /**
     * Imposta il numero di attributi che l'istruzione ha richiesto
     */
    void setRequestedAttributesNumber(int number);

    default int getAttribute(LinkedList<String> script) {
        if (getRequiredAttributesNumber() == getRequestedAttributesNumber())
            throw new RuntimeException("richiesti troppi attributi");
        setRequestedAttributesNumber(getRequestedAttributesNumber() + 1);
        return Integer.parseInt(Objects.requireNonNull(script.poll()));
    }

    /**
     * Restituisce il risultato dell'applicazione dell'istruzione all'environment.
     *
     * @param environment l'environment
     * @param script      lo script contenente il comando
     * @return l'environment modificato dall'esecuzione
     */
    Environment apply(Environment environment, LinkedList<String> script) throws IOException;



//
//    /**
//     * Restituisce il numero di attributi che l'istruzione necessita
//     *
//     * @return il numero di attributi che l'istruzione necessita
//     */
//    int getRequiredAttributesNumber();
//
//    /**
//     * Restituisce il numero di volte che sono stati richiesti gli attributi
//     */
//    int getCountRequestedAttributes();
//
//    /**
//     * Imposta il numero di attributi richiesti
//     *
//     * @param number il numero di attributi richiesti
//     */
//    void setCountRequestedAttributes(int number);
//
//    /**
//     * Incrementa di uno il numero di attributi richiesti
//     */
//    default void incrementCountRequestedAttributes() {
//        setCountRequestedAttributes(getCountRequestedAttributes() + 1);
//    }
//
//    /**
//     * Restituisce un attributo dall'istruzione
//     *
//     * @param instructions la coda di istruzioni
//     * @return un attributo dall'istruzione
//     */
//    default Integer getAttribute(LinkedList<String> instructions) {
//        incrementCountRequestedAttributes();
//        if (getCountRequestedAttributes() > getRequiredAttributesNumber())
//            throw new RuntimeException("Richiesti troppi attributi dall'istruzione");
//        return Integer.parseInt(Objects.requireNonNull(instructions.poll()));
//    }
}