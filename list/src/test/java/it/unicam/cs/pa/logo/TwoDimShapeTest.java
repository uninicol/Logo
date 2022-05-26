package it.unicam.cs.pa.logo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoDimShapeTest {

    @Test
    void add() {
        TwoDimShape shape = new TwoDimShape(new TwoDimSegment(new TwoDimCoordinate(50, 50), new TwoDimCoordinate(60, 50)));
        shape.add(new TwoDimSegment(new TwoDimCoordinate(60, 50), new TwoDimCoordinate(50, 60)));
        shape.add(new TwoDimSegment(new TwoDimCoordinate(50, 60), new TwoDimCoordinate(50, 50)));
        assertTrue(shape.isClosed());
    }
}