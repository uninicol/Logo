package it.unicam.cs.pa.logo.model;

import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimDrawer;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoDimDrawerTest {

    TwoDimEnvironment env;
    TwoDimDrawer drawer;

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(200, 200);
        drawer = new TwoDimDrawer(env);
    }

    @Test
    void drawLineRight() {
        env.getCursor().getDirection().increaseDirection(0);
        drawer.drawLine(500);
        assertEquals(new TwoDimCoordinate(200, 100), env.getCursor().getPosition());
    }

    @Test
    void drawLineDownRight() {
        env.getCursor().getDirection().increaseDirection(45);
        drawer.drawLine(500);
        assertEquals(new TwoDimCoordinate(200, 1), env.getCursor().getPosition());
    }

    @Test
    void drawLineDown() {
        env.getCursor().getDirection().increaseDirection(90);
        drawer.drawLine(500);
        assertEquals(new TwoDimCoordinate(100, 0), env.getCursor().getPosition());
    }

    @Test
    void drawLineDownLeft() {
        env.getCursor().getDirection().increaseDirection(135);
        drawer.drawLine(500);
        assertEquals(new TwoDimCoordinate(0, 0), env.getCursor().getPosition());
    }

    @Test
    void drawLineLeft() {
        env.getCursor().getDirection().increaseDirection(180);
        drawer.drawLine(500);
        assertEquals(new TwoDimCoordinate(0, 100), env.getCursor().getPosition());
    }

    @Test
    void drawLineUpLeft() {
        env.getCursor().getDirection().increaseDirection(225);
        drawer.drawLine(500);
        assertEquals(new TwoDimCoordinate(1, 200), env.getCursor().getPosition());
    }

    @Test
    void drawLineUp() {
        env.getCursor().getDirection().increaseDirection(270);
        drawer.drawLine(500);
        assertEquals(new TwoDimCoordinate(100, 200), env.getCursor().getPosition());
    }

    @Test
    void drawLineUpRight() {
        env.getCursor().getDirection().increaseDirection(315);
        drawer.drawLine(500);
        assertEquals(new TwoDimCoordinate(200, 200), env.getCursor().getPosition());
    }
}