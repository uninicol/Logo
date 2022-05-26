package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.DrawerClass;
import it.unicam.cs.pa.logo.TwoDimCoordinate;
import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.TwoDimSegment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.Deque;

/**
 * Classe che rappresenta l'istruzione BACKWARD
 */
public final class BackwardInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public BackwardInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void accept(Deque<String> instruction) {
        int distance = -getAttribute(instruction);
        //determino il punto di arrivo con dovuti limiti
        DrawerClass drawer = new DrawerClass(getEnvironment());
        drawer.drawLine(distance);
    }
}
