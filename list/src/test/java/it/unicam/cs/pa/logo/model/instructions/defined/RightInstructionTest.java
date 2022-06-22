package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import it.unicam.cs.pa.logo.model.instructions.InstructionRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RightInstructionTest {
    TwoDimEnvironment env;
    InstructionRegistry registry = InstructionRegistry.getTwoDimRegistrySet();

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);
    }

    @Test
    void drawRightTest() throws IOException {
        String script = "RIGHT 0 FORWARD 50";
        Instruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(script.split(" "))));
        assertEquals(new TwoDimCoordinate(550, 500), env.getCursor().getPosition());
    }

    @Test
    void drawDownTest() throws IOException {
        String script = "RIGHT 90 FORWARD 50";
        Instruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(script.split(" "))));
        assertEquals(new TwoDimCoordinate(500, 450), env.getCursor().getPosition());
    }

    @Test
    void drawLeftTest() throws IOException {
        String script = "RIGHT 180 FORWARD 50";
        Instruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(script.split(" "))));
        assertEquals(new TwoDimCoordinate(450, 500), env.getCursor().getPosition());
    }

    @Test
    void drawUpTest() throws IOException {
        String script = "RIGHT 270 FORWARD 50";
        Instruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(script.split(" "))));
        assertEquals(new TwoDimCoordinate(500, 550), env.getCursor().getPosition());
    }
}