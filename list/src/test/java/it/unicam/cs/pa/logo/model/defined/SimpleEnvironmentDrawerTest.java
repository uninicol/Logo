package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleEnvironmentDrawerTest {

    SimpleEnvironment environment;
    SimpleEnvironmentDrawer drawer;

    @BeforeEach
    void build() {
        environment = new SimpleEnvironment(1000, 1000, new SimpleCursor());
        drawer = new SimpleEnvironmentDrawer(environment);
    }

    @Test
    void draw() {
        Segment segment = new Segment(new Point(0, 0), new Point(10, 10));
        drawer.draw(segment);
        assertEquals(1, environment.getPolygons().size());
        assertEquals(new Point(10, 10), environment.getCursor().getPosition());
    }

    @Test
    void dontDraw() {
        Segment segment = new Segment(new Point(0, 0), new Point(10, 10));
        environment.getCursor().setPlot(false);
        drawer.draw(segment);
        assertEquals(0, environment.getPolygons().size());
        assertEquals(new Point(10, 10), environment.getCursor().getPosition());
    }
}