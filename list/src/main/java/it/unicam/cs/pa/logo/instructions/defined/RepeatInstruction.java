package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;
import it.unicam.cs.pa.logo.instructions.TwoDimInstructionFactory;

import java.util.Deque;

public final class RepeatInstruction extends AbstractInstruction<TwoDimEnvironment> {

    public RepeatInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void execute(Deque<String> instruction) {
        int num = getAttribute(instruction);
        for (int i = 0; i < num; i++) {
            new TwoDimInstructionFactory(getEnvironment()).execute(instruction);
        }
    }
}
