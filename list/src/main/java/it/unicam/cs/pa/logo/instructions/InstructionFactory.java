package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.Coordinate;
import it.unicam.cs.pa.logo.Direction;
import it.unicam.cs.pa.logo.Environment;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public abstract class InstructionFactory<E extends Environment<? extends Coordinate, ? extends Direction>> {
    private final E environment;
    Map<String, Instruction<E>> addedInstructionMap;

    protected InstructionFactory(E environment) {
        this.environment = environment;
        this.addedInstructionMap = new HashMap<>();
    }

    public void addInstruction(String name, Instruction<E> instruction) {
        addedInstructionMap.put(name, instruction);
    }

    public Map<String, Instruction<E>> getAddedInstructionMap() {
        return addedInstructionMap;
    }

    public abstract Instruction<E> createInstruction(String instructionName, E environment);

    public void execute(Deque<String> instructions) {
        Instruction<E> instruction = createInstruction(instructions.poll(), environment);
        instruction.accept(instructions);
    }
}