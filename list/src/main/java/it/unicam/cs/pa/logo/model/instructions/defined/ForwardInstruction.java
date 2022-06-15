package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimDrawer;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione FORWARD
 */
public final class ForwardInstruction extends AbstractInstruction<TwoDimEnvironment> {

    public ForwardInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void accept(LinkedList<String> instruction) {
        int distance = getAttribute(instruction);
        //determino il punto di arrivo con dovuti limiti
        TwoDimDrawer drawer = new TwoDimDrawer(getEnvironment());
        drawer.drawLine(distance);
    }
}