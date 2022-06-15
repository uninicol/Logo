package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RightInstructionTest {
    RightInstruction r;
    ForwardInstruction f;
    TwoDimEnvironment env;

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);
        r = new RightInstruction(env);
        f = new ForwardInstruction(env);
    }

    @Test
    void drawRightTest() {
        r.accept(new LinkedList<>(List.of("0")));
        f.accept(new LinkedList<>(List.of("50")));
        assertEquals(new TwoDimCoordinate(550, 500), env.getCursor().getPosition());
    }

    @Test
    void drawDownTest() {
        r.accept(new LinkedList<>(List.of("90")));
        f.accept(new LinkedList<>(List.of("50")));
        assertEquals(new TwoDimCoordinate(500, 450), env.getCursor().getPosition());
    }

    @Test
    void drawLeftTest() {
        r.accept(new LinkedList<>(List.of("180")));
        f.accept(new LinkedList<>(List.of("50")));
        assertEquals(new TwoDimCoordinate(450, 500), env.getCursor().getPosition());
    }

    @Test
    void drawUpTest() {
        r.accept(new LinkedList<>(List.of("270")));
        f.accept(new LinkedList<>(List.of("50")));
        assertEquals(new TwoDimCoordinate(500, 550), env.getCursor().getPosition());
    }
}