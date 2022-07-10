package it.unicam.cs.pa.logo.model;

import it.unicam.cs.pa.logo.model.defined.Cursor;
import it.unicam.cs.pa.logo.model.defined.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeTest {

    Environment environment;
    Drawer<Environment> drawer;

    @BeforeEach
    void build() {
        environment = new Environment(1000, 1000, new Cursor(new Point(500, 500), new Direction360()));
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
        TwoDimSegment s1 = new TwoDimSegment(new Point(50, 50), new Point(60, 60));
        drawer.drawLine(environment, s1);
        TwoDimSegment s2 = new TwoDimSegment(new Point(60, 60), new Point(70, 70));
        drawer.drawLine(environment, s2);
        environment.getCursor().setPlot(false);
        TwoDimSegment s3 = new TwoDimSegment(new Point(70, 70), new Point(80, 80));
        drawer.drawLine(environment, s3);
        assertEquals(1, environment.getShapes().size());
        assertEquals(2, environment.getShapes().get(0).numSegments());
        environment.getCursor().setPlot(true);
        TwoDimSegment s4 = new TwoDimSegment(new Point(80, 80), new Point(90, 90));
        drawer.drawLine(environment, s4);
        assertEquals(2, environment.getShapes().size());
    }

}