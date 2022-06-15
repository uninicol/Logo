package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione LEFT
 */
public final class LeftInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public LeftInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void accept(LinkedList<String> instruction) {
        int grade = -getAttribute(instruction);
        getEnvironment().getCursor().getDirection().increaseDirection(grade);
    }
}
