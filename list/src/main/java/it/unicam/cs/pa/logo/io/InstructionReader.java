package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

/**
 * Questa interfaccia è usata per trasformare una stringa in un istruzione
 */
@FunctionalInterface
public interface InstructionReader<I extends Instruction<E>, E extends Environment<?>> {

    /**
     * Restituisce l'istruzione associato alla stringa data
     *
     * @param str una stringa contenente un'istruzione
     * @return l'istruzione associata alla stringa data
     */
    I parse(String str, E environment);
}
