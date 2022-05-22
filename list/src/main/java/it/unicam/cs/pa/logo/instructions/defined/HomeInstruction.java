package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.List;

public final class HomeInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public HomeInstruction(TwoDimEnvironment environment) {
        super(0, environment);
    }

    @Override
    public void execute(List<Integer> instruction) {
        getEnvironment().getCursor().setPosition(getEnvironment().getHome());
    }
}
