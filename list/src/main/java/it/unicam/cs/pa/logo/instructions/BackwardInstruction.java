package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.TwoDimEnvironment;

import java.util.List;

public final class BackwardInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public BackwardInstruction(TwoDimEnvironment environment) {
        super("BACKWARD", 1, environment);
    }

    @Override
    public void execute(List<Integer> instruction) {

    }
}
