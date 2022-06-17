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
//    private final TwoDimEnvironment environment;
//
//    /**
//     * Indica se l'ultima linea è stata disegnata oppure no
//     */
//    private boolean isLastLineDrawn = true;
//
//
//    public TwoDimDrawer(TwoDimEnvironment environment) {
//        this.environment = environment;
//    }
//
//    @Override
//    public TwoDimEnvironment getEnvironment() {
//        return environment;
//    }
//
//    @Override
//    public void drawLine(Function<Integer, Integer> function, int distance, Color color) {
//        Segment<TwoDimCoordinate> segment = new TwoDimSegment(
//                environment.getCursor().getPosition(),
//                getCoordinateFromDistance(distance),
//                color,
//                function,
//                environment.getCursor().getSize());
//        if (environment.getCursor().isPlot()) {
//            draw(segment);
//        } else {
//            environment.getCursor().move(segment.getEndPoint());
//            isLastLineDrawn = false;
//        }
//    }
//
//    /**
//     * Traccia una linea retta tra due punti
//     *
//     * @param lenght la distanza da percorrere
//     */
//    public void drawLine(int lenght) {
//        Segment<TwoDimCoordinate> segment = new TwoDimSegment(
//                new TwoDimCoordinate(0, 0), new TwoDimCoordinate(0, 0));
//        drawLine(segment.getFunction(), lenght, Color.BLACK);//utilizza la retta
//    }
//
//    /**
//     * Traccia una linea retta tra due punti
//     *
//     * @param lenght la lunghezza della retta
//     * @param color  il colore della retta
//     */
//    public void drawLine(int lenght, Color color) {
//        Segment<TwoDimCoordinate> segment = new TwoDimSegment(
//                new TwoDimCoordinate(0, 0), new TwoDimCoordinate(0, 0));
//        drawLine(segment.getFunction(), lenght, color);//utilizza la retta
//    }
//
//    /**
//     * Disegna il segmento nell'environment
//     *
//     * @param segment il segmento da disegnare
//     */
//    private void draw(Segment<TwoDimCoordinate> segment) {
//        isLastLineDrawn = true;
//        if (environment.getShapes().isEmpty() || !isLastLineDrawn)
//            environment.getShapes().add(new TwoDimShape(segment));
//        else
//            environment.getShapes().get(environment.getShapes().size() - 1).add(segment);
//        environment.getCursor().move(segment.getEndPoint());
//    }
//
//    @Override
//    public TwoDimCoordinate getCoordinateFromDistance(int distance) {
//        int angle = environment.getCursor().getDirection().getValue();
//        int x = (int) Math.ceil(
//                environment.getCursor().getPosition().xAxis() + distance * Math.cos(Math.toRadians(angle))
//        );
//        int y = (int) Math.ceil(
//                environment.getCursor().getPosition().yAxis() + distance * Math.sin(Math.toRadians(angle) * -1)
//        );
//        if (!(x < 0 || x > environment.getLength()) && !(y < 0 || y > environment.getHeight()))
//            return new TwoDimCoordinate(x, y);
//        else return checkCoordinate(x, y, angle, distance);
//    }
//
//    /**
//     * Controlla se le coordinate sono all'interno dell'environment, se non lo sono vengono corretti e ricalcolati
//     *
//     * @param x     x da controllare
//     * @param y     y da controllare
//     * @param angle angolo del cursore
//     * @return le coordinate corrette
//     */
//    public TwoDimCoordinate checkCoordinate(int x, int y, int angle, int distance) {
//        int distanceDifference = getDistanceDifference(x, y, angle);
//        return getCoordinateFromDistance(distance - Math.abs(distanceDifference));
//    }
//
//    private int getDistanceDifference(int x, int y, int angle) {
//        int distanceDifference = checkX(x, angle);
//        if (distanceDifference != 0)
//            return distanceDifference;
//        else return checkY(y, angle);
//    }
//
//    private int checkX(int x, int angle) {
//        if (x > environment.getLength())
//            return (int) ((x - environment.getLength()) / Math.cos(Math.toRadians(angle)));
//        else if (x < 0)
//            return (int) (Math.abs(x) / Math.cos(Math.toRadians(angle)));
//        return 0;
//    }
//
//    private int checkY(int y, int angle) {
//        if (y > environment.getHeight())
//            if (angle == 270) return y - environment.getHeight();
//            else return (int) ((y - environment.getHeight()) / Math.cos(Math.toRadians(angle)));
//        else if (y < 0)
//            if (angle == 90) return Math.abs(y);
//            else return (int) (Math.abs(y) / Math.cos(Math.toRadians(angle)));
//        return 0;
//    }

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
        int angle = environment.getCursor().getDirection().getValue();
        int x = (int) Math.ceil(
                environment.getCursor().getPosition().getX() + length * Math.cos(Math.toRadians(angle))
        );
        int y = (int) Math.ceil(
                environment.getCursor().getPosition().getY() + length * Math.sin(Math.toRadians(angle) * -1)
        );
        Segment segment = new TwoDimSegment(environment.getCursor().getPosition(), new TwoDimCoordinate(x, y));
        return drawLine(segment);
    }

    private void draw(Segment segment) {
        List<Shape> shapes = environment.getShapes();
        if (shapes.isEmpty()) {
            shapes.add(new TwoDimShape(segment));
            environment.getCursor().move(segment.getEndPoint());
            return;
        }
        Shape lastShape = shapes.get(shapes.size() - 1);
        if (environment.getCursor().getPosition()
                .equals(lastShape.getLastPoint())) //l'ultimo segmento è stato tracciato
            lastShape.add(segment);
        else
            shapes.add(new TwoDimShape(segment));
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

    public void checkCoordinate(int x, int y, int angle, int distance) {
        int distanceDifference = getDistanceDifference(x, y, angle);
        drawLine(distance - Math.abs(distanceDifference));
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
