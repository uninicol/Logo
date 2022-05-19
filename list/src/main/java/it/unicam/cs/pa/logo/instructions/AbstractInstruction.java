package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.AbstractCursor;
import it.unicam.cs.pa.logo.Coordinate;
import it.unicam.cs.pa.logo.Environment;

import java.util.Queue;

public abstract class AbstractInstruction<E extends Environment<? extends Coordinate>>
        implements Instruction<Queue<String>, E> {

    final String name;
    final int numAttributes;

    protected AbstractInstruction(String name, int numAttributes) {
        this.name = name;
        this.numAttributes = numAttributes;
    }

    @Override
    public String getInstructionName() {
        return name;
    }

    @Override
    public int getRequiredAttributesNumber() {
        return numAttributes;
    }
}
