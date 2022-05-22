package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.List;

public final class PenupInstrucion extends AbstractInstruction<TwoDimEnvironment> {
    public PenupInstrucion(TwoDimEnvironment environment) {
        super(0, environment);
    }

    @Override
    public void execute(List<Integer> instruction) {
        getEnvironment().getCursor().setPlot(false);
    }
}
