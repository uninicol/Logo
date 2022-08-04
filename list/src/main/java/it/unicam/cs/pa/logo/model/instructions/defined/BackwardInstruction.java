package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleDrawer;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.geom.Point2D;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione BACKWARD, sposta il cursore indietro rispetto la sua direzione
 */
public final class BackwardInstruction extends Instruction<SimpleEnvironment> {
    public BackwardInstruction(SimpleEnvironment environment) {
        super(environment, 1);
    }

    @Override
    public SimpleEnvironment apply(Queue<String> script) {
        int length = -getAttribute(script);
        return new SimpleDrawer().drawLine(getEnvironment(), length);
    }

    @Override
    public String stringOf(SimpleEnvironment environment) {
        Point2D Point = environment.getCursor().getPosition();
        return String.format("spostato il cursore nella posizione x:%.0f y:%.0f", Point.getX(), Point.getY());
    }
}
