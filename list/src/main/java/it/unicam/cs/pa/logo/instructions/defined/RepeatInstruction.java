package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.List;

public final class RepeatInstruction extends AbstractInstruction<TwoDimEnvironment> {

    public RepeatInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void execute(List<Integer> instruction) {
        int num = instruction.get(0);
        //TwoDimInstructionFactory factory = new TwoDimInstructionFactory(getEnvironment()).execute(instruction);
    }
}
