package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.TwoDimCoordinate;
import it.unicam.cs.pa.logo.TwoDimEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;
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
    public void executeSimpleDrawSegmentTest() {
        Deque<String> command = new LinkedList<>(List.of("BACKWARD", "50"));
        factory.execute(command);
        assertEquals(new TwoDimCoordinate(450, 500), env.getCursor().getPosition());
        assertTrue(command.isEmpty());
        assertEquals(1, env.getShapes().size());
    }
    @Test
    public void executeDrawSegmentTest() {
        Deque<String> command = new LinkedList<>(List.of("BACKWARD", "-50"));
        factory.execute(command);
        assertEquals(new TwoDimCoordinate(550, 500), env.getCursor().getPosition());
        assertTrue(command.isEmpty());
        assertEquals(1, env.getShapes().size());
    }
}
