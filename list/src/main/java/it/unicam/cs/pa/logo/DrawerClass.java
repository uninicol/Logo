package it.unicam.cs.pa.logo;

import java.util.function.Function;

public class DrawerClass implements Drawer<TwoDimEnvironment, TwoDimCoordinate, TwoDimDirection> {
    private final TwoDimEnvironment environment;
    /**
     * Indica se l'ultima linea è stata disegnata oppure no
     */
    private boolean isLastLineDrawed = true;


    public DrawerClass(TwoDimEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public TwoDimEnvironment getEnvironment() {
        return environment;
    }

    @Override
    public void drawLine(Function<Integer, Integer> function, int distance) {
        if (environment.getCursor().isPlot()) {
            draw(distance, function);
        } else {
            environment.getCursor().move(getCoordinateFromDistance(distance));
            isLastLineDrawed = false;
        }
    }

    public void drawLine(int distance) {
        Segment<TwoDimCoordinate> segment = new TwoDimSegment(
                environment.getCursor().getPosition(), getCoordinateFromDistance(distance));
        drawLine(segment.getFunction(), distance);//utilizza la retta
    }

    private void draw(int distance, Function<Integer, Integer> function) {
        Segment<TwoDimCoordinate> segment = new TwoDimSegment(
                environment.getCursor().getPosition(), getCoordinateFromDistance(distance), function);
        isLastLineDrawed = true;
        if (environment.getShapes().isEmpty() || !isLastLineDrawed)
            environment.getShapes().add(new TwoDimShape(segment));
        else
            environment.getShapes().get(environment.getShapes().size() - 1).add(segment);
        environment.getCursor().move(segment.getEndPoint());
    }

    @Override
    public TwoDimCoordinate getCoordinateFromDistance(int distance) {
        int angle = environment.getCursor().getDirection().getDirectionValues().get(0);
        int x = (int) Math.ceil(
                environment.getCursor().getPosition().xAxis() + distance * Math.cos(Math.toRadians(angle))
        );
        int y = (int) Math.ceil(
                environment.getCursor().getPosition().yAxis() + distance * Math.sin(Math.toRadians(angle) * -1)
        );
        return checkCoordinate(x, y, angle);
    }

    public TwoDimCoordinate checkCoordinate(int x, int y, int angle) {
        if (x > environment.getLength()) {
            y = (int) Math.ceil(
                    y + (x - environment.getLength()) * Math.sin(Math.toRadians(angle))
            );
            x = environment.getLength();
        } else if (y > environment.getHeight()) {
            x = (int) Math.ceil(
                    x + (y - environment.getHeight()) * Math.cos(Math.toRadians(angle) * -1)
            );
            y = environment.getHeight();
        }
        return new TwoDimCoordinate(x, y);
    }
}
