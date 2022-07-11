package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Cursor;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.defined.SimpleDrawer;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.geom.Point2D;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione FORWARD, sposta il cursore in avanti verso la sua direzione
 */
public final class ForwardInstruction extends Instruction<Environment<Cursor>> {

    public ForwardInstruction(Environment<Cursor> environment) {
        super(environment, 1);
    }

    @Override
    public Environment<Cursor> apply(Queue<String> script) {
        int length = getAttribute(script);
        //determino il punto di arrivo con dovuti limitiz
        return new SimpleDrawer().drawLine(getEnvironment(), length);
    }

    @Override
    public String stringOf(Environment<Cursor> environment) {
        Point2D Point = environment.getCursor().getPosition();
        return String.format("spostato il cursore nella posizione x:%.0f y:%.0f", Point.getX(), Point.getY());
    }
}