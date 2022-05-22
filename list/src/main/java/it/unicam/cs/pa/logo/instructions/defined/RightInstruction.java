package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.List;

public final class RightInstruction extends AbstractInstruction<TwoDimEnvironment> {

    public RightInstruction(TwoDimEnvironment environment) {
        super( 1, environment);
    }

    @Override
    public void execute(List<Integer> instruction) {
        int grade = instruction.get(0);
        getEnvironment().getCursor().getDirection().increaseDirection(grade);
    }
}
