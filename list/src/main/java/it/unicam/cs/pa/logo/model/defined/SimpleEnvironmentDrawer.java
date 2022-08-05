package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Drawer;
import it.unicam.cs.pa.logo.model.Polygon;
import it.unicam.cs.pa.logo.model.Segment;
import it.unicam.cs.pa.logo.model.instructions.SegmentChecker;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * Questa classe rappresenta un disegnatore che disegna su un piano bidimensionale
 */
public class SimpleEnvironmentDrawer implements Drawer<Segment, SimpleEnvironment> {

    private final SimpleEnvironment environment;

    public SimpleEnvironmentDrawer(SimpleEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public SimpleEnvironment draw(Segment segment) {
        segment = new SegmentChecker(environment).check(segment);
        if (environment.getCursor().isPlot())
            draw(environment, segment);
        environment.getCursor().moveTo(segment.getP2());
        return environment;
    }

    /**
     * Disegna sull'environment il segmento
     *
     * @param environment l'environment che verrà disegnato
     * @param segment     il segmento da disegnare
     */
    private void draw(SimpleEnvironment environment, Segment segment) {
        List<Polygon> polygons = environment.getPolygons();
        Polygon polygon = new Polygon(Color.WHITE);
        polygon.addSegment(segment);
        if (polygons.isEmpty()) {
            polygons.add(polygon);
            environment.getCursor().moveTo(segment.getP2());
            return;
        }
        Polygon lastPolygon = polygons.get(polygons.size() - 1);
        if (isLastLineDrawn(environment)) //l'ultimo segmento è stato tracciato
            lastPolygon.addSegment(segment);
        else
            polygons.add(polygon);
    }

    /**
     * Verifica se l'ultimo segmento che è stato disegnato è collegato a quello che andremo a disegnare
     *
     * @param env l'environment
     * @return true se il segmento è collegato, false altrimenti
     */
    private boolean isLastLineDrawn(SimpleEnvironment env) {
        Polygon lastPolygon = env.getPolygons().get(env.getPolygons().size() - 1);
        Point2D lastPoint = lastPolygon.getSegments().get(lastPolygon.size() - 1).getP2();
        return env.getCursor().getPosition()
                .equals(lastPoint);
    }

//    /**
//     * Inserisce il segmento nella lista di poligoni dell'environment
//     *
//     * @return l'environment aggiornato
//     */
//    private SimpleEnvironment insertInPolygon() {
//        if (environment.getPolygons().isEmpty()) return environment;
//        Polygon lastPolygon = environment.getPolygons().get(environment.getPolygons().size() - 1);
//        if (lastPolygon.isClosed())
//            lastPolygon.setBackgroundColor(environment.getCursor().getAreaColor());
//        return environment;
//    }
}
