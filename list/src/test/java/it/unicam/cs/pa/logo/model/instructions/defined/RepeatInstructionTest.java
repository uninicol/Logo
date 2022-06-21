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
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepeatInstructionTest {

    TwoDimEnvironment env;
    InstructionRegistry registry = InstructionRegistry.getTwoDimRegistrySet();

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);
    }

    @Test
    public void executeDrawSegmentTest() throws IOException {
        String command = "REPEAT 3 [ FORWARD 50 ]";
        AbstractInstruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(command.split(" "))));
        assertEquals(new TwoDimCoordinate(650, 500), env.getCursor().getPosition());
    }

    @Test
    public void commandWithoutParenthesisTest() {
        assertThrows(IllegalArgumentException.class, () -> {
                    String command = "REPEAT 3 [ FORWARD 50";
                    AbstractInstruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(command.split(" "))));
                }
        );
    }

    @Test
    public void executeDrawSquareTest() throws IOException {
        String square = "REPEAT 4 [ FORWARD 50 RIGHT 90 ]";
        AbstractInstruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(square.split(" "))));
        assertEquals(new TwoDimCoordinate(500, 500), env.getCursor().getPosition());
    }

    @Test
    public void executeCommandAfterRepeat() throws IOException {
        String square = "REPEAT 4 [ FORWARD 50 RIGHT 90 ] FORWARD 50";
        AbstractInstruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(square.split(" "))));
        assertEquals(new TwoDimCoordinate(550, 500), env.getCursor().getPosition());
    }

    @Test
    public void innerRepeatInstruction() throws IOException {
        String script = "REPEAT 4 [ REPEAT 50 [ FORWARD 1 ] ]";
        AbstractInstruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(script.split(" "))));
        assertEquals(new TwoDimCoordinate(700, 500), env.getCursor().getPosition());
    }
}