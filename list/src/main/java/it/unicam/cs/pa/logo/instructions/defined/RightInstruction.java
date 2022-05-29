package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.Deque;
import java.util.LinkedList;

public final class RightInstruction extends AbstractInstruction<TwoDimEnvironment> {

    public RightInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void accept(LinkedList<String> instruction) {
        int grade = getAttribute(instruction);
        getEnvironment().getCursor().getDirection().increaseDirection(grade);
    }
}
