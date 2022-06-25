package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Coordinate;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.defined.TwoDimDrawer;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione BACKWARD, sposta il cursore indietro rispetto la sua direzione
 */
public final class BackwardInstruction extends Instruction {
    public BackwardInstruction() {
        super(1);
    }

    @Override
    public Environment apply(Environment environment, Queue<String> script) {
        int length = -getAttribute(script);
        return new TwoDimDrawer().drawLine(environment,length);
    }

    @Override
    public String stringOf(Environment environment) {
        Coordinate coordinate = environment.getCursor().getPosition();
        return String.format("spostato il cursore nella posizione x:%d y:%d", coordinate.getX(), coordinate.getY());
    }
}
