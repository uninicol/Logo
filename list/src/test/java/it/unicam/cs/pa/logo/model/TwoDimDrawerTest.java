package it.unicam.cs.pa.logo.model;

import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.defined.SimpleCursor;
import it.unicam.cs.pa.logo.model.defined.SimpleDrawer;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoDimDrawerTest {

    SimpleEnvironment env;
    SimpleDrawer drawer;

    @BeforeEach
    void build() {
        env = new SimpleEnvironment(200, 200, new SimpleCursor(new Point(100, 100), new Direction360()));
        drawer = new SimpleDrawer();
    }

    @Test
    void drawLineRight() {
        env.getCursor().getDirection().increase(0);
        drawer.drawLine(env, 500);
        assertEquals(new Point(200, 100), env.getCursor().getPosition());
    }

    @Test
    void drawLineDownRight() {
        env.getCursor().getDirection().increase(45);
        drawer.drawLine(env, 500);
        assertEquals(new Point(200, 1), env.getCursor().getPosition());
    }

    @Test
    void drawLineDown() {
        env.getCursor().getDirection().increase(90);
        drawer.drawLine(env, 500);
        assertEquals(new Point(100, 0), env.getCursor().getPosition());
    }

    @Test
    void drawLineDownLeft() {
        env.getCursor().getDirection().increase(135);
        drawer.drawLine(env, 500);
        assertEquals(new Point(0, 0), env.getCursor().getPosition());
    }

    @Test
    void drawLineLeft() {
        env.getCursor().getDirection().increase(180);
        drawer.drawLine(env, 500);
        assertEquals(new Point(0, 100), env.getCursor().getPosition());
    }

    @Test
    void drawLineUpLeft() {
        env.getCursor().getDirection().increase(225);
        drawer.drawLine(env, 500);
        assertEquals(new Point(1, 200), env.getCursor().getPosition());
    }

    @Test
    void drawLineUp() {
        env.getCursor().getDirection().increase(270);
        drawer.drawLine(env, 500);
        assertEquals(new Point(100, 200), env.getCursor().getPosition());
    }

    @Test
    void drawLineUpRight() {
        env.getCursor().getDirection().increase(315);
        drawer.drawLine(env, 500);
        assertEquals(new Point(200, 200), env.getCursor().getPosition());
    }
}