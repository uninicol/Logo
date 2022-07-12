package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.io.InstructionLoader;
import it.unicam.cs.pa.logo.io.InstructionReader;
import it.unicam.cs.pa.logo.model.Cursor;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RightInstructionTest {
    Environment<?> env;
    InstructionReader<Instruction<Environment<?>>, Environment<?>> registry = InstructionLoader.DEFAULT_LOGO_READER;

    @BeforeEach
    void build() {
        env = new Environment<>(1000, 1000, new Cursor<>(new Point(500, 500), new Direction360()));
    }

    @Test
    void drawRightTest() {
        String script = "RIGHT 0 FORWARD 50";
        Instruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(script.split(" "))));
        assertEquals(new Point(550, 500), env.getCursor().getPosition());
    }

    @Test
    void drawDownTest() {
        String script = "RIGHT 90 FORWARD 50";
        Instruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(script.split(" "))));
        assertEquals(new Point(500, 450), env.getCursor().getPosition());
    }

    @Test
    void drawLeftTest() {
        String script = "RIGHT 180 FORWARD 50";
        Instruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(script.split(" "))));
        assertEquals(new Point(450, 500), env.getCursor().getPosition());
    }

    @Test
    void drawUpTest() {
        String script = "RIGHT 270 FORWARD 50";
        Instruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(script.split(" "))));
        assertEquals(new Point(500, 550), env.getCursor().getPosition());
    }
}