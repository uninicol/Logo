package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.Deque;
import java.util.LinkedList;

public final class PendownInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public PendownInstruction(TwoDimEnvironment environment) {
        super(0, environment);
    }

    @Override
    public void accept(LinkedList<String> instruction) {
        getEnvironment().getCursor().setPlot(true);
    }
}
