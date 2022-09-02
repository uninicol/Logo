package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Segment;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironmentDrawer;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.geom.Point2D;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione FORWARD, sposta il cursore in avanti verso la sua direzione
 */
public final class ForwardInstruction implements Instruction<SimpleEnvironment> {

    @Override
    public String stringOf(SimpleEnvironment environment) {
        Point2D Point = environment.getCursor().getPosition();
        return String.format("spostato il cursore nella posizione x:%.0f y:%.0f", Point.getX(), Point.getY());
    }

    @Override
    public SimpleEnvironment apply(SimpleEnvironment environment, Queue<String> script) {
        int length = getIntegerAttribute(script);
        Segment segment =
                new Segment(environment.getCursor().getPosition(),
                        getPointFromDistance(length, environment),
                        environment.getCursor().getSize(),
                        environment.getCursor().getLineColor());
        return new SimpleEnvironmentDrawer(environment).draw(segment);
    }

    /**
     * Restituisce le Point distanti verso una direzione
     *
     * @param distance la distanza tra le due Point
     * @return le Point distanti verso una direzione
     */
    private Point2D getPointFromDistance(double distance, SimpleEnvironment environment) {
        double angle = environment.getCursor().getDirection().getValue();
        Point2D start = environment.getCursor().getPosition();
        return BackwardInstruction.getPointFromDistance(distance, angle, start);
    }
}