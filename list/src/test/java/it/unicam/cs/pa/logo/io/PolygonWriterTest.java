package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Polygon;
import it.unicam.cs.pa.logo.model.Segment;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolygonWriterTest {

    @Test
    void stringOf() {
        Polygon polygon = new Polygon(new Color(90, 23, 12));
        polygon.addSegment(new Segment(new Point(10, 10), new Point(20, 10), new Color(12, 56, 56)));
        polygon.addSegment(new Segment(new Point(20, 10), new Point(15, 20), 3, new Color(23, 56, 34)));
        polygon.addSegment(new Segment(new Point(15, 20), new Point(10, 10), 2, new Color(45, 87, 2)));
        PolygonWriter writer = new PolygonWriter();
        assertEquals("POLYGON 3 90 23 12\n10 10 12 56 56 1\n20 10 23 56 34 3\n15 20 45 87 2 2\n"
                , writer.stringOf(polygon));
    }
}