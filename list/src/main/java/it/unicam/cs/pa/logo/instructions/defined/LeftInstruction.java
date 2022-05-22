package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.List;

public final class LeftInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public LeftInstruction(TwoDimEnvironment environment) {
        super( 1, environment);
    }

    @Override
    public void execute(List<Integer> instruction) {
        new RightInstruction(getEnvironment())
                .execute(
                        List.of(-instruction.get(0))
                );
    }
}
