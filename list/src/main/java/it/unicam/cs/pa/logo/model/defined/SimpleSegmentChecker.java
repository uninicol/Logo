package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Segment;
import it.unicam.cs.pa.logo.model.instructions.SegmentChecker;

import java.awt.*;
import java.awt.geom.Point2D;


/**
 * Verifica se il segmento è correttamente all'interno dell'environment
 */
public final class SimpleSegmentChecker implements SegmentChecker<Segment, SimpleEnvironment> {

    @Override
    public Segment check(Segment segment, SimpleEnvironment environment) {
        if (!(environment.contains(segment.getP2()))) {
            Point2D point = new Point((int) checkX(segment, environment), (int) checkY(segment, environment));
            return new Segment(segment.getP1(), point);
        }
        return segment;
    }

    /**
     * Controlla se il punto x è all'interno dell'environment
     *
     * @return il punto x all'interno dell'environment
     */
    private double checkX(Segment segment, SimpleEnvironment environment) {
        int angle = environment.getCursor().getDirection().getValue();
        if (segment.x2 > environment.getWidth())
            return segment.x2 - ((segment.x2 - environment.getWidth()) / Math.cos(Math.toRadians(angle)));
        else if (segment.getP2().getX() < 0)
            return segment.x2 - (Math.abs(segment.x2) / Math.cos(Math.toRadians(angle)));
        return segment.x2;
    }

    /**
     * Controlla se il punto y è all'interno dell'environment
     *
     * @return il punto y all'interno dell'environment
     */
    private double checkY(Segment segment, SimpleEnvironment environment) {
        int angle = environment.getCursor().getDirection().getValue();
        if (segment.y2 > environment.getHeight())
            if (angle == 270) return segment.y2 - (segment.y2 - environment.getHeight());
            else return segment.y2 - ((segment.y2 - environment.getHeight()) / Math.cos(Math.toRadians(angle)));
        else if (segment.y2 < 0)
            if (angle == 90) return Math.abs(segment.y2);
            else return segment.y2 - (Math.abs(segment.y2) / Math.cos(Math.toRadians(angle)));
        return segment.y2;
    }
}
