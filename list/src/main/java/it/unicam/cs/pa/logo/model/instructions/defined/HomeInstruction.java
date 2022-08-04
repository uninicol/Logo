package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.geom.Point2D;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione HOME, muove il cursore nella posizione di home
 */
public final class HomeInstruction extends Instruction<SimpleEnvironment> {

    public HomeInstruction(SimpleEnvironment environment) {
        super(environment, 0);
    }

    @Override
    public SimpleEnvironment apply(Queue<String> script) {
        getEnvironment().getCursor().moveTo(getEnvironment().getHome());
        return getEnvironment();
    }

    @Override
    public String stringOf(SimpleEnvironment environment) {
        Point2D Point = environment.getCursor().getPosition();
        return String.format("spostato il cursore nella posizione di home x:%.0f y:%.0f", Point.getX(), Point.getY());
    }
}
