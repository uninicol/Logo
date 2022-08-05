package it.unicam.cs.pa.logo.model;

import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.defined.SimpleCursor;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironmentDrawer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SegmentCheckerTest {

    SimpleEnvironment env;
    SimpleEnvironmentDrawer drawer;

    @BeforeEach
    void build() {
        this.env = new SimpleEnvironment(200, 200, new SimpleCursor(new Direction360()));
        this.drawer = new SimpleEnvironmentDrawer(env);
    }

    @Test
    void drawRight() {
        env.getCursor().getDirection().increase(0);
        Point2D start = new Point(100, 100);
        Point2D end = new Point(201, 100);
        drawer.draw(new Segment(start, end));
        assertEquals(new Point(200, 100), env.getCursor().getPosition());
    }

    @Test
    void drawDownRight() {
        env.getCursor().getDirection().increase(45);
        Point2D start = new Point(100, 100);
        Point2D end = new Point(201, -1);
        drawer.draw(new Segment(start, end));
        assertEquals(new Point(199, -2), env.getCursor().getPosition());
    }

    @Test
    void drawDown() {
        env.getCursor().getDirection().increase(90);
        Point2D start = new Point(100, 100);
        Point2D end = new Point(100, -1);
        drawer.draw(new Segment(start, end));
        assertEquals(new Point(100, 1), env.getCursor().getPosition());
    }

    @Test
    void drawDownLeft() {
        env.getCursor().getDirection().increase(135);
        Point2D start = new Point(100, 100);
        Point2D end = new Point(-1, -1);
        drawer.draw(new Segment(start, end));
        assertEquals(new Point(0, 0), env.getCursor().getPosition());
    }

    @Test
    void drawLeft() {
        env.getCursor().getDirection().increase(180);
        Point2D start = new Point(100, 100);
        Point2D end = new Point(-1, 100);
        drawer.draw(new Segment(start, end));
        assertEquals(new Point(0, 100), env.getCursor().getPosition());
    }

    @Test
    void drawUpLeft() {
        env.getCursor().getDirection().increase(225);
        Point2D start = new Point(100, 100);
        Point2D end = new Point(-1, 201);
        drawer.draw(new Segment(start, end));
        assertEquals(new Point(0, 202), env.getCursor().getPosition());
    }

    @Test
    void drawUp() {
        env.getCursor().getDirection().increase(270);
        Point2D start = new Point(100, 100);
        Point2D end = new Point(100, 201);
        drawer.draw(new Segment(start, end));
        assertEquals(new Point(100, 200), env.getCursor().getPosition());
    }

    @Test
    void drawUpRight() {
        env.getCursor().getDirection().increase(315);
        Point2D start = new Point(100, 100);
        Point2D end = new Point(201, 201);
        drawer.draw(new Segment(start, end));
        assertEquals(new Point(199, 199), env.getCursor().getPosition());
    }
}