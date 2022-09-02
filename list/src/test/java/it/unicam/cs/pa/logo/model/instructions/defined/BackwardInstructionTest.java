package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.defined.SimpleCursor;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackwardInstructionTest {

    SimpleEnvironment env;
    BackwardInstruction instruction;

    @BeforeEach
    void build() {
        env = new SimpleEnvironment(1000, 1000, new SimpleCursor(new Direction360()));
        instruction = new BackwardInstruction();
    }

    private Queue<String> getIntegerAttributes(String str) {
        return new LinkedList<>(List.of(str.strip()));
    }

    @Test
    void executeRight() {
        instruction.apply(env,getIntegerAttributes("50"));
        assertEquals(new Point(500 - 50, 500), env.getCursor().getPosition());
    }

    @Test
    void executeDown() {
        env.getCursor().getDirection().increase(90);
        instruction.apply(env,getIntegerAttributes("50"));
        assertEquals(new Point(500, 500 + 50), env.getCursor().getPosition());
    }

    @Test
    void executeLeft() {
        env.getCursor().getDirection().increase(180);
        instruction.apply(env,getIntegerAttributes("50"));
        assertEquals(new Point(500 + 50, 500), env.getCursor().getPosition());
    }

    @Test
    void executeUp() {
        env.getCursor().getDirection().increase(270);
        instruction.apply(env,getIntegerAttributes("50"));
        assertEquals(new Point(500, 500 - 50), env.getCursor().getPosition());
    }
}
