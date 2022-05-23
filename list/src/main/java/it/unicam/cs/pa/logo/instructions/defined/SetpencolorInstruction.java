package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.awt.*;
import java.util.Deque;

public final class SetpencolorInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public SetpencolorInstruction(TwoDimEnvironment environment) {
        super(3, environment);
    }

    @Override
    public void accept(Deque<String> instruction) {
        getEnvironment().getCursor().setLineColor(
                new Color(
                        getAttribute(instruction), getAttribute(instruction), getAttribute(instruction)
                )
        );
    }
}
