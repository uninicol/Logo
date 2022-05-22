package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.List;

public final class BackwardInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public BackwardInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void execute(List<Integer> instruction) {
        new ForwardInstruction(getEnvironment())
                .execute(
                        List.of(-instruction.get(0))
                );
    }
}
