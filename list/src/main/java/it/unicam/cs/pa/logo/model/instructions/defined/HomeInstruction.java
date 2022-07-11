package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione HOME, muove il cursore nella posizione di home
 */
public final class HomeInstruction extends Instruction<Environment> {

    public HomeInstruction(Environment environment) {
        super(environment, 0);
    }

    @Override
    public Environment apply(Queue<String> script) {
        getEnvironment().getCursor().move(getEnvironment().getHome());
        return getEnvironment();
    }

    @Override
    public String stringOf(Environment environment) {
        Point2D Point = environment.getCursor().getPosition();
        return String.format("spostato il cursore nella posizione di home x:%f y:%f", Point.getX(), Point.getY());
    }
}
