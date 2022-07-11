package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Direction;
import it.unicam.cs.pa.logo.model.Drawer;
import it.unicam.cs.pa.logo.model.Segment;
import it.unicam.cs.pa.logo.model.Shape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * Questa classe rappresenta un disegnatore che disegna su un piano bidimensionale
 */
public class SimpleDrawer implements Drawer<Environment> {
//    @Override
//    public Environment drawLine(Environment environment, Segment segment) {
//        checkSegment(environment, segment, segment.getP1().distance(segment.getP2()));
//        if (environment.getCursor().isPlot())
//            draw(environment, segment);
//        environment.getCursor().move(segment.getP2());
//        if (environment.getShapes().isEmpty()) return environment;
//        Shape lastShape = environment.getShapes().get(environment.getShapes().size() - 1);
//        if (lastShape.isClosed())
//            lastShape.setBackgroundColor(environment.getCursor().getAreaColor());
//        return environment;
//    }
//
//    @Override
//    public Environment drawLine(Environment environment, int length) {
//        Segment segment = new Segment(environment.getCursor().getPosition(), getPointFromDistance(environment, length));
//        return drawLine(environment, segment);
//    }
//
//    public Point getPointFromDistance(double distance, Cursor cursor) {
//        int angle = cursor.getDirection().getValue();
//        int x = (int) Math.ceil(
//                cursor.getPosition().getX() + distance * Math.cos(Math.toRadians(angle))
//        );
//        int y = (int) Math.ceil(
//                cursor.getPosition().getY() + distance * Math.sin(Math.toRadians(angle) * -1)
//        );
//        return new Point(x, y);
//    }
//
//    /**
//     * Restituisce le Point distanti verso una direzione
//     *
//     * @param environment l'environment dove sono contenute le Point
//     * @param distance    la distanza tra le due Point
//     * @return le Point distanti verso una direzione
//     */
//    public Point getPointFromDistance(Environment environment, double distance) {
//        Point Point = getPointFromDistance(distance, environment.getCursor());
//        if (environment.contains(Point))
//            return new Point((int) Point.getX(), (int) Point.getY());
//        else
//            return checkPoint(
//                    environment, Point, distance);
//    }
//
//    /**
//     * Verifica se le Point ottenute sono all'interno dell'environment
//     *
//     * @param environment l'environment
//     * @param Point  le Point da verificare
//     * @param distance    la distanza tra la coordinata di partenza e di fine
//     * @return la coordinata all'interno dell'environment
//     */
//    public Point checkPoint(Environment environment, Point Point, double distance) {
//        double distanceDifference = getDistanceDifference(environment, Point);
//        return getPointFromDistance(environment, Math.abs(distance - Math.abs(distanceDifference)));
//    }
//
//    /**
//     * Disegna sull'environment il segmento
//     *
//     * @param environment l'environment che verrà disegnato
//     * @param segment     il segmento da disegnare
//     */
//    private void draw(Environment environment, Segment segment) {
//        List<Shape> shapes = environment.getShapes();
//        if (shapes.isEmpty()) {
//            shapes.add(new Shape(segment));
//            environment.getCursor().move(segment.getP2());
//            return;
//        }
//        Shape lastShape = shapes.get(shapes.size() - 1);
//        if (isLastLineDrawn(environment)) //l'ultimo segmento è stato tracciato
//            lastShape.add(segment);
//        else
//            shapes.add(new Shape(segment));
//    }
//
//    /**
//     * Verifica se l'ultimo segmento che è stato disegnato è collegato a quello che andremo a disegnare
//     *
//     * @param env l'environment
//     * @return true se il segmento è collegato, false altrimenti
//     */
//    private boolean isLastLineDrawn(Environment env) {
//        return env.getCursor().getPosition()
//                .equals(env.getShapes().get(env.getShapes().size() - 1).getLastPoint());
//    }
//
//    /**
//     * Verifica se il segmento è all'interno dell'environment
//     *
//     * @param environment l'environment
//     * @param segment     il segmento
//     * @param length      la lunghezza del segmento
//     */
//    private void checkSegment(Environment environment, Segment segment, double length) {
//        int x = (int) segment.getP2().getX();
//        int y = (int) segment.getP2().getY();
//        Point Point = new Point(x, y);
//        if (!environment.contains(Point))
//            checkPoint(environment, Point, length);
//    }
//
//    /**
//     * Restituisce la lunghezza tra la coordinata e il bordo dell'environment
//     *
//     * @param environment l'environment
//     * @param Point  le Point fuori dall'environment
//     * @return la differenza tra il punto fuori e quello all'interno dell'environment
//     */
//    private double getDistanceDifference(Environment environment, Point Point) {
//        double distanceDifference = checkX(environment, Point.getX());
//        if (distanceDifference != 0)
//            return distanceDifference;
//        else return checkY(environment, Point.getY());
//    }
//
//    /**
//     * Controlla se il punto x è all'interno dell'environment
//     *
//     * @param environment l'environment
//     * @param x           il punto x
//     * @return il punto x all'interno dell'environment
//     */
//    private double checkX(Environment environment, double x) {
//        int angle = environment.getCursor().getDirection().getValue();
//        if (x > environment.getWidth())
//            return (int) ((x - environment.getWidth()) / Math.cos(Math.toRadians(angle)));
//        else if (x < 0)
//            return (int) (Math.abs(x) / Math.cos(Math.toRadians(angle)));
//        return 0;
//    }
//
//    /**
//     * Controlla se il punto y è all'interno dell'environment
//     *
//     * @param environment l'environment
//     * @param y           il punto y
//     * @return il punto y all'interno dell'environment
//     */
//    private double checkY(Environment environment, double y) {
//        int angle = environment.getCursor().getDirection().getValue();
//        if (y > environment.getHeight())
//            if (angle == 270) return y - environment.getHeight();
//            else return (int) ((y - environment.getHeight()) / Math.cos(Math.toRadians(angle)));
//        else if (y < 0)
//            if (angle == 90) return Math.abs(y);
//            else return (int) (Math.abs(y) / Math.cos(Math.toRadians(angle)));
//        return 0;
//    }

    @Override
    public Environment drawLine(Environment environment, Segment segment) {
        checkSegment(environment, segment, segment.getP1().distance(segment.getP2()));
        if (environment.getCursor().isPlot())
            draw(environment, segment);
        environment.getCursor().move(segment.getP2());
        if (environment.getShapes().isEmpty()) return environment;
        Shape lastShape = environment.getShapes().get(environment.getShapes().size() - 1);
        if (lastShape.isClosed())
            lastShape.setBackgroundColor(environment.getCursor().getAreaColor());
        return environment;
    }

    @Override
    public Environment drawLine(Environment environment, int length) {
        Segment segment =
                new Segment(environment.getCursor().getPosition(), getPointFromDistance(environment, length), Color.WHITE);
        return drawLine(environment, segment);
    }

    /**
     * Restituisce le Point distanti verso una direzione
     *
     * @param environment l'environment dove sono contenute le Point
     * @param distance    la distanza tra le due Point
     * @return le Point distanti verso una direzione
     */
    private Point getPointFromDistance(Environment environment, double distance) {
        Point point =
                getPointFromDistance(environment.getCursor().getPosition(), distance, environment.getCursor().getDirection());
        if (environment.contains(point))
            return point;
        else return checkPoint(environment, point, distance);
    }

    /**
     * Restituisce le coordinate distanti verso una direzione
     *
     * @param start     il punto di partenza
     * @param distance  la distanza
     * @param direction la direzione
     * @return le coordinate distanti verso una direzione
     */
    private Point getPointFromDistance(Point2D start, double distance, Direction direction) {
        double angle = direction.getValue();
        double x = Math.ceil(
                start.getX() + distance * Math.cos(Math.toRadians(angle))
        );
        double y = Math.ceil(
                start.getY() + distance * Math.sin(Math.toRadians(angle) * -1)
        );
        return new Point((int) x, (int) y);
    }

    /**
     * Verifica se le point ottenute sono all'interno dell'environment
     *
     * @param environment l'environment
     * @param point       le point da verificare
     * @param distance    la distanza tra la coordinata di partenza e di fine
     * @return la coordinata all'interno dell'environment
     */
    private Point checkPoint(Environment environment, Point point, double distance) {
        double distanceDifference = getDistanceDifference(environment, point);
        return getPointFromDistance(environment, Math.abs(distance - Math.abs(distanceDifference)));
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
            shapes.add(new Shape(segment, Color.WHITE));
            environment.getCursor().move(segment.getP2());
            return;
        }
        Shape lastShape = shapes.get(shapes.size() - 1);
        if (isLastLineDrawn(environment)) //l'ultimo segmento è stato tracciato
            lastShape.addSegment(segment);
        else
            shapes.add(new Shape(segment, Color.WHITE));
    }

    /**
     * Verifica se l'ultimo segmento che è stato disegnato è collegato a quello che andremo a disegnare
     *
     * @param env l'environment
     * @return true se il segmento è collegato, false altrimenti
     */
    private boolean isLastLineDrawn(Environment env) {
        Shape lastShape = env.getShapes().get(env.getShapes().size() - 1);
        Point2D lastPoint = lastShape.getSegments().get(lastShape.size() - 1).getP2();
        return env.getCursor().getPosition()
                .equals(lastPoint);
    }

    /**
     * Verifica se il segmento è all'interno dell'environment
     *
     * @param environment l'environment
     * @param segment     il segmento
     * @param length      la lunghezza del segmento
     */
    private void checkSegment(Environment environment, Segment segment, double length) {
        int x = (int) segment.getP2().getX();
        int y = (int) segment.getP2().getY();
        Point point = new Point(x, y);
        if (!(environment.contains(point)))
            checkPoint(environment, point, length);
    }

    /**
     * Restituisce la lunghezza tra la coordinata e il bordo dell'environment
     *
     * @param environment l'environment
     * @param point       le point fuori dall'environment
     * @return la differenza tra il punto fuori e quello all'interno dell'environment
     */
    private double getDistanceDifference(Environment environment, Point point) {
        double distanceDifference = checkX(environment, point.getX());
        if (distanceDifference != 0)
            return distanceDifference;
        else return checkY(environment, point.getY());
    }

    /**
     * Controlla se il punto x è all'interno dell'environment
     *
     * @param environment l'environment
     * @param x           il punto x
     * @return il punto x all'interno dell'environment
     */
    private double checkX(Environment environment, double x) {
        double angle = environment.getCursor().getDirection().getValue();
        if (x > environment.getWidth())
            return ((x - environment.getWidth()) / Math.cos(Math.toRadians(angle)));
        else if (x < 0)
            return (Math.abs(x) / Math.cos(Math.toRadians(angle)));
        return 0;
    }

    /**
     * Controlla se il punto y è all'interno dell'environment
     *
     * @param environment l'environment
     * @param y           il punto y
     * @return il punto y all'interno dell'environment
     */
    private double checkY(Environment environment, double y) {
        double angle = environment.getCursor().getDirection().getValue();
        if (y > environment.getHeight())
            if (angle == 270) return y - environment.getHeight();
            else return ((y - environment.getHeight()) / Math.cos(Math.toRadians(angle)));
        else if (y < 0)
            if (angle == 90) return Math.abs(y);
            else return (Math.abs(y) / Math.cos(Math.toRadians(angle)));
        return 0;
    }
}
