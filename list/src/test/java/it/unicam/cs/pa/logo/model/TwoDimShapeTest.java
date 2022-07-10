package it.unicam.cs.pa.logo.model;

import it.unicam.cs.pa.logo.model.defined.TwoDimSegment;
import it.unicam.cs.pa.logo.model.defined.TwoDimShape;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoDimShapeTest {

    @Test
    void add() {
        TwoDimShape shape = new TwoDimShape(new TwoDimSegment(new Point(50, 50), new Point(60, 50)));
        shape.add(new TwoDimSegment(new Point(60, 50), new Point(50, 60)));
        shape.add(new TwoDimSegment(new Point(50, 60), new Point(50, 50)));
        assertTrue(shape.isClosed());
    }
}