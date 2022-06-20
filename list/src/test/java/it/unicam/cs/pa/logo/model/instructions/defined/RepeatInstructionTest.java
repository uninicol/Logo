package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.InstructionExecutor;
import it.unicam.cs.pa.logo.model.instructions.InstructionRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatInstructionTest {

    TwoDimEnvironment env;
    InstructionRegistry registry = InstructionRegistry.getTwoDimRegistrySet();
    InstructionExecutor executor;

    public RepeatInstructionTest() throws IOException {
    }

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);
    }

    @Test
    public void executeDrawSegmentTest() throws IOException {
        String command = "REPEAT 3 [ FORWARD 50 ]";
        executor = new InstructionExecutor(registry, env, command);
        executor.executeScript();
        assertEquals(new TwoDimCoordinate(650, 500), env.getCursor().getPosition());
    }

    @Test
    public void commandWithoutParenthesisTest() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            String command = "REPEAT 3 [ FORWARD 50";
//            executor.executeScript(command);
//        }
    }

    @Test
    public void executeDrawSquareTest() throws IOException {
        String square = "REPEAT 4 [ FORWARD 50 RIGHT 90 ]";
        executor = new InstructionExecutor(registry, env, square);
        executor.executeScript();
        assertEquals(new TwoDimCoordinate(500, 500), env.getCursor().getPosition());
    }
}