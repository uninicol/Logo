package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Segment;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironmentDrawer;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione FORWARD, sposta il cursore in avanti verso la sua direzione
 */
public final class ForwardInstruction extends Instruction<SimpleEnvironment> {

    public ForwardInstruction(SimpleEnvironment environment) {
        super(environment, 1);
    }

    @Override
    public SimpleEnvironment apply(Queue<String> script) {
        int length = getAttribute(script);
        Segment segment =
                new Segment(getEnvironment().getCursor().getPosition(),
                        getPointFromDistance(length),
                        getEnvironment().getCursor().getSize(),
                        getEnvironment().getCursor().getLineColor());
        return new SimpleEnvironmentDrawer(getEnvironment()).draw(segment);
    }

    /**
     * Restituisce le Point distanti verso una direzione
     *
     * @param distance la distanza tra le due Point
     * @return le Point distanti verso una direzione
     */
    private Point2D getPointFromDistance(double distance) {
        double angle = getEnvironment().getCursor().getDirection().getValue();
        Point2D start = getEnvironment().getCursor().getPosition();
        double x = Math.ceil(
                start.getX() + distance * Math.cos(Math.toRadians(angle))
        );
        double y = Math.ceil(
                start.getY() + distance * Math.sin(Math.toRadians(angle) * -1)
        );
        return new Point((int) x, (int) y);
    }

    @Override
    public String stringOf(SimpleEnvironment environment) {
        Point2D Point = environment.getCursor().getPosition();
        return String.format("spostato il cursore nella posizione x:%.0f y:%.0f", Point.getX(), Point.getY());
    }
}