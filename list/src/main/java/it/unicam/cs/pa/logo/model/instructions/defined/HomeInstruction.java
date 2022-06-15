package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione HOME
 */
public final class HomeInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public HomeInstruction(TwoDimEnvironment environment) {
        super(0, environment);
    }

    @Override
    public void accept(LinkedList<String> instruction) {
        getEnvironment().getCursor().move(getEnvironment().getHome());
    }
}
