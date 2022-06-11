package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.model.Coordinate;
import it.unicam.cs.pa.logo.model.Direction;
import it.unicam.cs.pa.logo.model.Environment;

import java.util.LinkedList;

/**
 * Factory usata per interpretare ed eseguire istruzioni
 *
 * @param <E> l'environment su cui opera la factory
 */
public abstract class InstructionFactory<E extends Environment<? extends Coordinate<?>, ? extends Direction<?>>> {
    private final E environment;

    protected InstructionFactory(E environment) {
        this.environment = environment;
    }

    public abstract Instruction<E> createInstruction(String instructionName, E environment);

    public void execute(LinkedList<String> instructions) {
        Instruction<E> instruction = createInstruction(instructions.poll(), environment);
        instruction.accept(instructions);
    }
}