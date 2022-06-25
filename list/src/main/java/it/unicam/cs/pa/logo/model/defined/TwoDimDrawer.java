package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.*;

import java.util.List;

/**
 * Questa classe rappresenta un disegnatore che disegna su un piano bidimensionale
 */
public class TwoDimDrawer implements Drawer {
    @Override
    public Environment drawLine(Environment environment, Segment segment) {
        checkSegment(environment, segment, segment.getStartPoint().distance(segment.getEndPoint()));
        if (environment.getCursor().isPlot())
            draw(environment, segment);
        environment.getCursor().move(segment.getEndPoint());
        if (environment.getShapes().isEmpty()) return environment;
        Shape lastShape = environment.getShapes().get(environment.getShapes().size() - 1);
        if (lastShape.isClosed())
            lastShape.setBackgroundColor(environment.getCursor().getAreaColor());
        return environment;
    }

    @Override
    public Environment drawLine(Environment environment, int length) {
        Segment segment = new TwoDimSegment(environment.getCursor().getPosition(), getCoordinateFromDistance(environment, length));
        return drawLine(environment, segment);
    }

    /**
     * Restituisce le coordinate distanti verso una direzione
     *
     * @param environment l'environment dove sono contenute le coordinate
     * @param distance    la distanza tra le due coordinate
     * @return le coordinate distanti verso una direzione
     */
    public Coordinate getCoordinateFromDistance(Environment environment, int distance) {
        Coordinate coordinate = environment.getCursor().getPosition().getCoordinateFromDistance(distance, environment.getCursor().getDirection());
        if (environment.contains(coordinate))
            return new TwoDimCoordinate(coordinate.getX(), coordinate.getY());
        else
            return checkCoordinate(
                    environment, coordinate, distance);
    }

    /**
     * Verifica se le coordinate ottenute sono all'interno dell'environment
     *
     * @param environment l'environment
     * @param coordinate  le coordinate da verificare
     * @param distance    la distanza tra la coordinata di partenza e di fine
     * @return la coordinata all'interno dell'environment
     */
    public Coordinate checkCoordinate(Environment environment, Coordinate coordinate, int distance) {
        int distanceDifference = getDistanceDifference(environment, coordinate);
        return getCoordinateFromDistance(environment, Math.abs(distance - Math.abs(distanceDifference)));
    }

    /**
     * Disegna sull'environment il segmento
     *
     * @param environment l'environment che verrà disegnato
     * @param segment     il segmento da disegnare
     */
    private void draw(Environment environment, Segment segment) {
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

    /**
     * Verifica se l'ultimo segmento che è stato disegnato è collegato a quello che andremo a disegnare
     *
     * @param env l'environment
     * @return true se il segmento è collegato, false altrimenti
     */
    private boolean isLastLineDrawn(Environment env) {
        return env.getCursor().getPosition()
                .equals(env.getShapes().get(env.getShapes().size() - 1).getLastPoint());
    }

    /**
     * Verifica se il segmento è all'interno dell'environment
     *
     * @param environment l'environment
     * @param segment     il segmento
     * @param length      la lunghezza del segmento
     */
    private void checkSegment(Environment environment, Segment segment, int length) {
        int x = segment.getEndPoint().getX();
        int y = segment.getEndPoint().getY();
        Coordinate coordinate = new TwoDimCoordinate(x, y);
        if (!environment.contains(coordinate))
            checkCoordinate(environment, coordinate, length);
    }

    /**
     * Restituisce la lunghezza tra la coordinata e il bordo dell'environment
     *
     * @param environment l'environment
     * @param coordinate  le coordinate fuori dall'environment
     * @return la differenza tra il punto fuori e quello all'interno dell'environment
     */
    private int getDistanceDifference(Environment environment, Coordinate coordinate) {
        int distanceDifference = checkX(environment, coordinate.getX());
        if (distanceDifference != 0)
            return distanceDifference;
        else return checkY(environment, coordinate.getY());
    }

    /**
     * Controlla se il punto x è all'interno dell'environment
     *
     * @param environment l'environment
     * @param x           il punto x
     * @return il punto x all'interno dell'environment
     */
    private int checkX(Environment environment, int x) {
        int angle = environment.getCursor().getDirection().getValue();
        if (x > environment.getLength())
            return (int) ((x - environment.getLength()) / Math.cos(Math.toRadians(angle)));
        else if (x < 0)
            return (int) (Math.abs(x) / Math.cos(Math.toRadians(angle)));
        return 0;
    }

    /**
     * Controlla se il punto y è all'interno dell'environment
     *
     * @param environment l'environment
     * @param y           il punto y
     * @return il punto y all'interno dell'environment
     */
    private int checkY(Environment environment, int y) {
        int angle = environment.getCursor().getDirection().getValue();
        if (y > environment.getHeight())
            if (angle == 270) return y - environment.getHeight();
            else return (int) ((y - environment.getHeight()) / Math.cos(Math.toRadians(angle)));
        else if (y < 0)
            if (angle == 90) return Math.abs(y);
            else return (int) (Math.abs(y) / Math.cos(Math.toRadians(angle)));
        return 0;
    }
}
