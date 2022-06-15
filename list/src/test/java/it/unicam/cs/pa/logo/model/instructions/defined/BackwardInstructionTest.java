package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.InstructionFactory;
import it.unicam.cs.pa.logo.model.instructions.TwoDimInstructionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BackwardInstructionTest {

    TwoDimEnvironment env;
    InstructionFactory<TwoDimEnvironment> factory;

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);
        factory = new TwoDimInstructionFactory(env);
    }

    @Test
    public void executeSimpleDrawSegmentTest() throws IOException {
        LinkedList<String> command = new LinkedList<>(List.of("BACKWARD", "50"));
        factory.execute(command);
        assertEquals(new TwoDimCoordinate(450, 500), env.getCursor().getPosition());

        assertTrue(command.isEmpty());
        assertEquals(1, env.getShapes().size());
    }

    @Test
    public void executeDrawSegmentTest()throws IOException {
        LinkedList<String> command = new LinkedList<>(List.of("BACKWARD", "-50"));
        factory.execute(command);
        assertEquals(new TwoDimCoordinate(550, 500), env.getCursor().getPosition());
        assertTrue(command.isEmpty());
        assertEquals(1, env.getShapes().size());
    }

    @Test
    public void dontDrawOnlyMovesTest()throws IOException {
        env.getCursor().setPlot(false);
        LinkedList<String> command = new LinkedList<>(List.of("BACKWARD", "50"));
        factory.execute(command);
        assertEquals(new TwoDimCoordinate(450, 500), env.getCursor().getPosition());
        assertTrue(env.getShapes().isEmpty());
    }
}
