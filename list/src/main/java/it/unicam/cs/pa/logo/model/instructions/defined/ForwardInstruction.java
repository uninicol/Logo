package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.Environment;
import it.unicam.cs.pa.logo.model.defined.SimpleDrawer;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione FORWARD, sposta il cursore in avanti verso la sua direzione
 */
public final class ForwardInstruction extends Instruction<Environment> {

    public ForwardInstruction(Environment environment) {
        super(environment, 1);
    }

    @Override
    public Environment apply(Queue<String> script) {
        int length = getAttribute(script);
        //determino il punto di arrivo con dovuti limitiz
        return new SimpleDrawer().drawLine(getEnvironment(), length);
    }

    @Override
    public String stringOf(Environment environment) {
        Point Point = environment.getCursor().getPosition();
        return String.format("spostato il cursore nella posizione x:%f y:%f", Point.getX(), Point.getY());
    }
}