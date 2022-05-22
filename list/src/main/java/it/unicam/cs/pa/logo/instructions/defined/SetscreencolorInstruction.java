package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.Deque;
import java.util.List;

public final class SetscreencolorInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public SetscreencolorInstruction(TwoDimEnvironment environment) {
        super(3, environment);
    }

    @Override
    public void execute(Deque<String> instruction) {
        getEnvironment().setBackgroundColor(
                getAttribute(instruction), getAttribute(instruction), getAttribute(instruction)
        );
    }
}
