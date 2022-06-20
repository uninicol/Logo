package it.unicam.cs.pa.logo.model.instructions;

import java.io.IOException;

/**
 * Questa classe è usata per creare e restituire oggetti di tipo Instruction
 *
 * @param <I>
 */
public interface Registry<I extends Instruction> {

    /**
     * Crea una nuova istruzione
     *
     * @param name il nome del comando
     * @return il comando creato
     */
    I createInstruction(String name) throws IOException;

    /**
     * Restituisce l'istruzione associato al nome
     *
     * @param name il nome dell'istruzione
     * @return l'istruzione
     */
    I get(String name);
}
