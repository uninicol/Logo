package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Segment;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironmentDrawer;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Queue;

public final class BackwardInstruction implements Instruction<SimpleEnvironment> {

    @Override
    public String stringOf(SimpleEnvironment environment) {
        Point2D Point = environment.getCursor().getPosition();
        return String.format("spostato il cursore nella posizione x:%.0f y:%.0f", Point.getX(), Point.getY());
    }

    @Override
    public SimpleEnvironment apply(SimpleEnvironment environment, Queue<String> script) {
        int length = -getIntegerAttribute(script);
        Segment segment =
                new Segment(environment.getCursor().getPosition(),
                        getPointFromDistance(environment, length),
                        environment.getCursor().getSize(),
                        environment.getCursor().getLineColor());
        return new SimpleEnvironmentDrawer(environment).draw(segment);
    }

    /**
     * Restituisce il punto distante verso una direzione
     *
     * @param distance la distanza tra le due Point
     * @return le Point distanti verso una direzione
     */
    private Point2D getPointFromDistance(SimpleEnvironment environment, double distance) {
        double angle = environment.getCursor().getDirection().getValue();
        Point2D start = environment.getCursor().getPosition();
        return getPointFromDistance(distance, angle, start);
    }

    static Point2D getPointFromDistance(double distance, double angle, Point2D start) {
        double x = Math.ceil(
                start.getX() + distance * Math.cos(Math.toRadians(angle))
        );
        double y = Math.ceil(
                start.getY() + distance * Math.sin(Math.toRadians(angle) * -1)
        );
        return new Point((int) x, (int) y);
    }
}
