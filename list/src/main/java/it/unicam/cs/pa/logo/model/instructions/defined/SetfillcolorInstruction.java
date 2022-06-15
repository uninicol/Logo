package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.awt.*;
import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione SETFILLCOLOR
 */
public final class SetfillcolorInstruction extends AbstractInstruction<TwoDimEnvironment> {

    public SetfillcolorInstruction(TwoDimEnvironment environment) {
        super(3, environment);
    }

    @Override
    public void accept(LinkedList<String> instruction) {
        getEnvironment().getCursor().setLineColor(
                new Color(
                        getAttribute(instruction), getAttribute(instruction), getAttribute(instruction)
                )
        );
    }
}
