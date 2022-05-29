package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione SETPENSIZE
 */
public final class SetpensizeInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public SetpensizeInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void accept(LinkedList<String> instruction) {
        getEnvironment().getCursor().setSize(getAttribute(instruction));
    }
}
