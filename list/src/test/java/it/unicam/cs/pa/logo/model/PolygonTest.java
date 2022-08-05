package it.unicam.cs.pa.logo.model;

import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.defined.SimpleCursor;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironmentDrawer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PolygonTest {

    SimpleEnvironment environment;
    SimpleEnvironmentDrawer drawer;

    @BeforeEach
    void build() {
        environment = new SimpleEnvironment(1000, 1000, new SimpleCursor(new Point(500, 500), new Direction360()));
        drawer = new SimpleEnvironmentDrawer(environment);
    }

    @Test
    void drawSegmentTest() {
        drawer.draw(new Segment(new Point(10, 10), new Point(20, 20)));
        environment.getCursor().setPlot(false);
        drawer.draw(new Segment(new Point(20, 20), new Point(30, 30)));
        environment.getCursor().setPlot(true);
        drawer.draw(new Segment(new Point(30, 30), new Point(40, 40)));
        assertEquals(2, environment.getPolygons().size());
    }

    @Test
    void draw() {
        Segment s1 = new Segment(new Point(50, 50), new Point(60, 60));
        drawer.draw(s1);
        Segment s2 = new Segment(new Point(60, 60), new Point(70, 70));
        drawer.draw(s2);
        environment.getCursor().setPlot(false);
        Segment s3 = new Segment(new Point(70, 70), new Point(80, 80));
        drawer.draw(s3);
        assertEquals(1, environment.getPolygons().size());
        assertEquals(2, environment.getPolygons().get(0).size());
        environment.getCursor().setPlot(true);
        Segment s4 = new Segment(new Point(80, 80), new Point(90, 90));
        drawer.draw(s4);
        assertEquals(2, environment.getPolygons().size());
    }

    @Test
    void isClosedTest() {
        Polygon polygon = new Polygon(Color.WHITE);
        polygon.addSegment(new Segment(new Point(50, 50), new Point(60, 50)));
        polygon.addSegment(new Segment(new Point(60, 50), new Point(50, 60)));
        polygon.addSegment(new Segment(new Point(50, 60), new Point(50, 50)));
        assertTrue(polygon.isClosed());
    }

}