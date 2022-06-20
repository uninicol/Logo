package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.InstructionExecutor;
import it.unicam.cs.pa.logo.model.instructions.InstructionRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BackwardInstructionTest {

    TwoDimEnvironment env;
    InstructionRegistry registry = InstructionRegistry.getTwoDimRegistrySet();
    InstructionExecutor executor;

    public BackwardInstructionTest() throws IOException {
    }

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);
    }

    @Test
    public void executeSimpleDrawSegmentTest() throws IOException {
        String command = "BACKWARD 50";
        executor = new InstructionExecutor(registry, env, command);
        executor.executeScript();
        assertEquals(new TwoDimCoordinate(450, 500), env.getCursor().getPosition());
        assertEquals(1, env.getShapes().size());
    }

    @Test
    public void executeDrawSegmentTest() throws IOException {
        String command = "BACKWARD -50";
        executor = new InstructionExecutor(registry, env, command);
        executor.executeScript();
        assertEquals(new TwoDimCoordinate(550, 500), env.getCursor().getPosition());
        assertEquals(1, env.getShapes().size());
    }

    @Test
    public void dontDrawOnlyMovesTest() throws IOException {
        env.getCursor().setPlot(false);
        String command = "BACKWARD 50";
        executor = new InstructionExecutor(registry, env, command);
        executor.executeScript();
        assertEquals(new TwoDimCoordinate(450, 500), env.getCursor().getPosition());
        assertTrue(env.getShapes().isEmpty());
    }
}
