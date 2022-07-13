package it.unicam.cs.pa.logo.model;

import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.defined.SimpleDrawer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PolygonTest {

    Environment<?> environment;
    Drawer<Environment<?>> drawer;

    @BeforeEach
    void build() {
        environment = new Environment<>(1000, 1000, new Cursor<>(new Point(500, 500), new Direction360()));
        drawer = new SimpleDrawer();
    }

    @Test
    void drawSegmentTest() {
        drawer.drawLine(environment, 90);
        environment.getCursor().setPlot(false);
        drawer.drawLine(environment, 90);
        environment.getCursor().setPlot(true);
        drawer.drawLine(environment, 90);
        assertEquals(2, environment.getShapes().size());
    }

    @Test
    void drawLine() {
        Segment s1 = new Segment(new Point(50, 50), new Point(60, 60));
        drawer.drawLine(environment, s1);
        Segment s2 = new Segment(new Point(60, 60), new Point(70, 70));
        drawer.drawLine(environment, s2);
        environment.getCursor().setPlot(false);
        Segment s3 = new Segment(new Point(70, 70), new Point(80, 80));
        drawer.drawLine(environment, s3);
        assertEquals(1, environment.getShapes().size());
        assertEquals(2, environment.getShapes().get(0).size());
        environment.getCursor().setPlot(true);
        Segment s4 = new Segment(new Point(80, 80), new Point(90, 90));
        drawer.drawLine(environment, s4);
        assertEquals(2, environment.getShapes().size());
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