package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.io.InstructionWriter;
import it.unicam.cs.pa.logo.model.defined.TwoDimDrawer;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

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
        TwoDimDrawer drawer = new TwoDimDrawer(getEnvironment());
        drawer.drawLine(distance);
    }
}