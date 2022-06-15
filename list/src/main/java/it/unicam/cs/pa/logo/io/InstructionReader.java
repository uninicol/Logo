package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Coordinate;
import it.unicam.cs.pa.logo.model.Direction;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.io.IOException;

/**
 * Questa interfaccia è usata per trasformare una stringa in un istruzione
 *
 * @param <I> il tipo di istruzione
 */
@FunctionalInterface
public interface InstructionReader<I extends Instruction<? extends Environment
        <? extends Coordinate, ? extends Direction>>> {

    /**
     * Restituisce l'istruzione associato alla stringa data
     *
     * @param str una stringa contenente un'istruzione
     * @return l'istruzione associata alla stringa data
     * @throws IOException se la stringa non è corretta
     */
    I parse(String str) throws IOException;
}
