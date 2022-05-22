package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.List;

public final class SetscreencolorInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public SetscreencolorInstruction(TwoDimEnvironment environment) {
        super(3, environment);
    }

    @Override
    public void execute(List<Integer> instruction) {
        getEnvironment().setBackgroundColor(instruction.get(0), instruction.get(1), instruction.get(2));
    }
}
