package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione RIGHT
 */
public final class RightInstruction extends AbstractInstruction<TwoDimEnvironment> {

    public RightInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void accept(LinkedList<String> instruction) {
        int grade = getAttribute(instruction);
        getEnvironment().getCursor().getDirection().increaseDirection(grade);
    }
}
