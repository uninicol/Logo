package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Questa interfaccia è usata per trasformare una stringa in un istruzione
 */
@FunctionalInterface
public interface InstructionReader <I extends Instruction>{

    /**
     * Restituisce l'istruzione associato alla stringa data
     *
     * @param str una stringa contenente un'istruzione
     * @return l'istruzione associata alla stringa data
     */
    Function<String,I> parse(String str);
}