package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.Deque;
import java.util.List;

public final class ClearscreenInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public ClearscreenInstruction(TwoDimEnvironment environment) {
        super(0, environment);
    }

    @Override
    public void execute(Deque<String> instruction) {
        getEnvironment().clearAll();
    }
}
