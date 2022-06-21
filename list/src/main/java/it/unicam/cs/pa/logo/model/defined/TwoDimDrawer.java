package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Drawer;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.Segment;
import it.unicam.cs.pa.logo.model.Shape;

import java.util.List;

/**
 * Questa classe rappresenta un disegnatore che disegna su un piano bidimensionale
 */
public class TwoDimDrawer implements Drawer {
    private final Environment environment;

    public TwoDimDrawer(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Environment drawLine(Segment segment) {
        checkSegment(segment, segment.getStartPoint().distance(segment.getEndPoint()));
        if (environment.getCursor().isPlot())
            draw(segment);
        environment.getCursor().move(segment.getEndPoint());
        return environment;
    }

    @Override
    public Environment drawLine(int length) {
        Segment segment = new TwoDimSegment(environment.getCursor().getPosition(), getCoordinateFromDistance(length));
        return drawLine(segment);
    }

    public TwoDimCoordinate getCoordinateFromDistance(int distance) {
        int angle = environment.getCursor().getDirection().getValue();
        int x = (int) Math.ceil(
                environment.getCursor().getPosition().getX() + distance * Math.cos(Math.toRadians(angle))
        );
        int y = (int) Math.ceil(
                environment.getCursor().getPosition().getY() + distance * Math.sin(Math.toRadians(angle) * -1)
        );
        if (!(x < 0 || x > environment.getLength()) && !(y < 0 || y > environment.getHeight()))
            return new TwoDimCoordinate(x, y);
        else return checkCoordinate(x, y, angle, distance);
    }

    public TwoDimCoordinate checkCoordinate(int x, int y, int angle, int distance) {
        int distanceDifference = getDistanceDifference(x, y, angle);
        return getCoordinateFromDistance(Math.abs(distance - Math.abs(distanceDifference)));
    }

    private void draw(Segment segment) {
        List<Shape> shapes = environment.getShapes();
        if (shapes.isEmpty()) {
            shapes.add(new TwoDimShape(segment));
            environment.getCursor().move(segment.getEndPoint());
            return;
        }
        Shape lastShape = shapes.get(shapes.size() - 1);
        if (isLastLineDrawn(environment)) //l'ultimo segmento è stato tracciato
            lastShape.add(segment);
        else
            shapes.add(new TwoDimShape(segment));
    }

    private boolean isLastLineDrawn(Environment env) {
        return env.getCursor().getPosition()
                .equals(env.getShapes().get(env.getShapes().size() - 1).getLastPoint());
    }

    private void checkSegment(Segment segment, int length) {
        int x = segment.getEndPoint().getX();
        int y = segment.getEndPoint().getY();
        if (x < 0
                || x > environment.getLength()
                || y < 0
                || y > environment.getHeight())
            checkCoordinate(x, y, environment.getCursor().getDirection().getValue(), length);
    }

    private int getDistanceDifference(int x, int y, int angle) {
        int distanceDifference = checkX(x, angle);
        if (distanceDifference != 0)
            return distanceDifference;
        else return checkY(y, angle);
    }

    private int checkX(int x, int angle) {
        if (x > environment.getLength())
            return (int) ((x - environment.getLength()) / Math.cos(Math.toRadians(angle)));
        else if (x < 0)
            return (int) (Math.abs(x) / Math.cos(Math.toRadians(angle)));
        return 0;
    }

    private int checkY(int y, int angle) {
        if (y > environment.getHeight())
            if (angle == 270) return y - environment.getHeight();
            else return (int) ((y - environment.getHeight()) / Math.cos(Math.toRadians(angle)));
        else if (y < 0)
            if (angle == 90) return Math.abs(y);
            else return (int) (Math.abs(y) / Math.cos(Math.toRadians(angle)));
        return 0;
    }
}
