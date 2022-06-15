package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Coordinate;
import it.unicam.cs.pa.logo.model.Direction;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

/**
 * Questa interfaccia è usata per trasformare un'istruzione in una stringa
 *
 * @param <I> il tipo dell'istruzione
 */
@FunctionalInterface
public interface InstructionWriter<I extends Instruction<? extends Environment
        <? extends Coordinate, ? extends Direction>>> {

    /**
     * Restituisce la stringa che rappresenta l'istruzione
     *
     * @param instr un'istruzione.
     * @return la stringa che rappresenta l'istruzione
     */
    String stringOf(I instr);
}
