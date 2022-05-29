package it.unicam.cs.pa.logo;

import java.util.function.Function;

/**
 * Questa classe rappresenta un disegnatore che disegna su un piano bidimensionale
 */
public class TwoDimDrawer implements Drawer<TwoDimEnvironment, TwoDimCoordinate, TwoDimDirection> {
    private final TwoDimEnvironment environment;
    /**
     * Indica se l'ultima linea è stata disegnata oppure no
     */
    private boolean isLastLineDrawn = true;


    public TwoDimDrawer(TwoDimEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public TwoDimEnvironment getEnvironment() {
        return environment;
    }

    @Override
    public void drawLine(Function<Integer, Integer> function, int distance) {
        Segment<TwoDimCoordinate> segment = new TwoDimSegment(
                environment.getCursor().getPosition(),
                getCoordinateFromDistance(distance),
                function,
                environment.getCursor().getSize());
        if (environment.getCursor().isPlot()) {
            draw(segment);
        } else {
            environment.getCursor().move(segment.getEndPoint());
            isLastLineDrawn = false;
        }
    }

    /**
     * Prende come parametro la distanza e utilizza una retta "default" passante per due punti
     *
     * @param distance la distanza da percorrere
     */
    public void drawLine(int distance) {
        Segment<TwoDimCoordinate> segment = new TwoDimSegment(
                new TwoDimCoordinate(0, 0), new TwoDimCoordinate(0, 0));
        drawLine(segment.getFunction(), distance);//utilizza la retta
    }

    /**
     * Disegna il segmento nell'environment
     *
     * @param segment il segmento da disegnare
     */
    private void draw(Segment<TwoDimCoordinate> segment) {
        isLastLineDrawn = true;
        if (environment.getShapes().isEmpty() || !isLastLineDrawn)
            environment.getShapes().add(new TwoDimShape(segment));
        else
            environment.getShapes().get(environment.getShapes().size() - 1).add(segment);
        environment.getCursor().move(segment.getEndPoint());
    }

    @Override
    public TwoDimCoordinate getCoordinateFromDistance(int distance) {
        int angle = environment.getCursor().getDirection().getAngle();
        int x = (int) Math.ceil(
                environment.getCursor().getPosition().xAxis() + distance * Math.cos(Math.toRadians(angle))
        );
        int y = (int) Math.ceil(
                environment.getCursor().getPosition().yAxis() + distance * Math.sin(Math.toRadians(angle) * -1)
        );
        if (!(x < 0 || x > environment.getLength()) && !(y < 0 || y > environment.getHeight()))
            return new TwoDimCoordinate(x, y);
        else return checkCoordinate(x, y, angle, distance);
    }

    /**
     * Controlla se le coordinate sono all'interno dell'environment, se non lo sono vengono corretti e ricalcolati
     *
     * @param x     x da controllare
     * @param y     y da controllare
     * @param angle angolo del cursore
     * @return le coordinate corrette
     */
    public TwoDimCoordinate checkCoordinate(int x, int y, int angle, int distance) {
        int distanceDifference = 0;
        if (x > environment.getLength())
            distanceDifference = (int) ((x - environment.getLength()) / Math.cos(Math.toRadians(angle)));
        else if (x < 0)
            distanceDifference = (int) (Math.abs(x) / Math.cos(Math.toRadians(angle)));
        else if (y > environment.getHeight())
            if (angle == 270) distanceDifference = y - environment.getHeight();
            else distanceDifference = (int) ((y - environment.getHeight()) / Math.cos(Math.toRadians(angle)));
        else if (y < 0)
            if (angle == 90) distanceDifference = Math.abs(y);
            else distanceDifference = (int) (Math.abs(y) / Math.cos(Math.toRadians(angle)));
        return getCoordinateFromDistance(distance-Math.abs(distanceDifference));
    }
}
