package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.awt.*;
import java.util.List;

public final class SetpencolorInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public SetpencolorInstruction(TwoDimEnvironment environment) {
        super(3, environment);
    }

    @Override
    public void execute(List<Integer> instruction) {
        getEnvironment().getCursor().setLineColor(
                new Color(
                        instruction.get(0), instruction.get(1), instruction.get(2)
                ));
    }
}
