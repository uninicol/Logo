package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;
import it.unicam.cs.pa.logo.model.instructions.InstructionRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BackwardInstructionTest {

    TwoDimEnvironment env;
    InstructionRegistry registry = InstructionRegistry.getTwoDimRegistrySet();

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);
    }

    @Test
    public void executeSimpleDrawSegmentTest() throws IOException {
        String command = "BACKWARD 50";
        AbstractInstruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(command.split(" "))));
        assertEquals(new TwoDimCoordinate(450, 500), env.getCursor().getPosition());
        assertEquals(1, env.getShapes().size());
    }

    @Test
    public void executeDrawSegmentTest() throws IOException {
        String command = "BACKWARD -50";
        LinkedList<String> script = new LinkedList<>(List.of(command.split(" ")));
        AbstractInstruction.EXECUTOR.execute(registry, env, script);
        assertEquals(new TwoDimCoordinate(550, 500), env.getCursor().getPosition());
        assertEquals(1, env.getShapes().size());
    }

    @Test
    public void dontDrawOnlyMovesTest() throws IOException {
        env.getCursor().setPlot(false);
        String command = "BACKWARD 50";
        AbstractInstruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(command.split(" "))));
        assertEquals(new TwoDimCoordinate(450, 500), env.getCursor().getPosition());
        assertTrue(env.getShapes().isEmpty());
    }
}
