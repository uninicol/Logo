package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Coordinate;
import it.unicam.cs.pa.logo.model.Drawer;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.defined.TwoDimDrawer;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione FORWARD, sposta il cursore in avanti verso la sua direzione
 */
public final class ForwardInstruction extends Instruction {

    public ForwardInstruction() {
        super(1);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) {
        int length = getAttribute(script);
        //determino il punto di arrivo con dovuti limitiz
        return new TwoDimDrawer().drawLine(environment,length);
    }

    @Override
    public String stringOf(Environment environment) {
        Coordinate coordinate = environment.getCursor().getPosition();
        return String.format("spostato il cursore nella posizione x:%d y:%d", coordinate.getX(), coordinate.getY());
    }
}