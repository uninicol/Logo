package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Segment;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SegmentWriterTest {
    EnvironmentWriter<Segment> writer = new SegmentWriter();

    @Test
    void stringOf() {
        Segment segment = new Segment(new Point(0, 0), new Point(10, 10), 5, Color.black);
        assertEquals("LINE 0 0 10 10 0 0 0 5\n", writer.stringOf(segment));
    }
}