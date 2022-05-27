package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.Deque;

public final class PendownInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public PendownInstruction(TwoDimEnvironment environment) {
        super(0, environment);
    }

    @Override
    public void accept(Deque<String> instruction) {
        getEnvironment().getCursor().setPlot(true);
    }
}
