package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.instructions.Instruction;
import it.unicam.cs.pa.logo.model.instructions.Registry;

import java.io.IOException;

/**
 * Questa interfaccia è usata per trasformare una stringa in un istruzione
 */
@FunctionalInterface
public interface InstructionReader<I extends Instruction> {

    /**
     * Restituisce l'istruzione associato alla stringa data
     *
     * @param str una stringa contenente un'istruzione
     * @return l'istruzione associata alla stringa data
     * @throws IOException se la stringa non è corretta
     */
    Instruction parse(Registry<I> registry, String str) throws IOException;
}
