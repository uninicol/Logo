package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione SETSCREENCOLOR
 */
public final class SetscreencolorInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public SetscreencolorInstruction(TwoDimEnvironment environment) {
        super(3, environment);
    }

    @Override
    public void accept(LinkedList<String> instruction) {
        getEnvironment().setBackgroundColor(
                getAttribute(instruction), getAttribute(instruction), getAttribute(instruction)
        );
    }
}
