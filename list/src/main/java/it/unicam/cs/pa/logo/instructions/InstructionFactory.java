package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.Coordinate;
import it.unicam.cs.pa.logo.Environment;

import java.util.Deque;
import java.util.Queue;

public abstract class InstructionFactory<E extends Environment<? extends Coordinate>> {

    private final E environment;

    protected InstructionFactory(E environment) {
        this.environment = environment;
    }

    public abstract Instruction<E> createInstruction(String instructionName, E environment);

    public void execute(Deque<String> instructions) {
        Instruction<E> instruction = createInstruction(instructions.poll(), environment);
        instruction.execute(instructions);
        //for (int i = 0; i < instruction.getRequiredAttributesNumber(); i++) instructions.poll();
    }
}