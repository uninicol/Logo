package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.TwoDimEnvironment;

import java.util.List;

public class ForwardInstruction extends AbstractInstruction<TwoDimEnvironment>{

    protected ForwardInstruction(String name, int numAttributes) {
        super(name, numAttributes);
    }

    @Override
    public TwoDimEnvironment apply(List<String> strings) {
        return null;
    }
}
