package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimDrawer;
import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione BACKWARD
 */
public final class BackwardInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public BackwardInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void accept(LinkedList<String> instruction) {
        int distance = -getAttribute(instruction);
        //determino il punto di arrivo con dovuti limiti
        TwoDimDrawer drawer = new TwoDimDrawer(getEnvironment());
        drawer.drawLine(distance);
    }
}