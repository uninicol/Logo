package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.InstructionExecutor;
import it.unicam.cs.pa.logo.model.instructions.InstructionRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RightInstructionTest {
    TwoDimEnvironment env;
    InstructionRegistry registry = InstructionRegistry.getTwoDimRegistrySet();
    InstructionExecutor executor;

    RightInstructionTest() throws IOException {
    }

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);

    }

    @Test
    void drawRightTest() throws IOException {
        String script ="RIGHT 0 FORWARD 50";
        executor = new InstructionExecutor(registry, env, script);
        executor.executeScript();
        assertEquals(new TwoDimCoordinate(550, 500), env.getCursor().getPosition());
    }

    @Test
    void drawDownTest() throws IOException {
        String script ="RIGHT 90 FORWARD 50";
        executor = new InstructionExecutor(registry, env, script);
        executor.executeScript();
        assertEquals(new TwoDimCoordinate(500, 450), env.getCursor().getPosition());
    }

    @Test
    void drawLeftTest() throws IOException {
        String script ="RIGHT 180 FORWARD 50";
        executor = new InstructionExecutor(registry, env, script);
        executor.executeScript();
        assertEquals(new TwoDimCoordinate(450, 500), env.getCursor().getPosition());
    }

    @Test
    void drawUpTest() throws IOException {
        String script ="RIGHT 270 FORWARD 50";
        executor = new InstructionExecutor(registry, env, script);
        executor.executeScript();
        assertEquals(new TwoDimCoordinate(500, 550), env.getCursor().getPosition());
    }
}