package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.io.InstructionLoader;
import it.unicam.cs.pa.logo.io.InstructionReader;
import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.defined.SimpleCursor;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import it.unicam.cs.pa.logo.model.instructions.LOGOExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepeatInstructionTest {

    SimpleEnvironment env;
    InstructionReader<Instruction<SimpleEnvironment>, SimpleEnvironment> registry = InstructionLoader.DEFAULT_LOGO_READER;

    @BeforeEach
    void build() {
        env = new SimpleEnvironment(1000, 1000, new SimpleCursor(new Point(500, 500), new Direction360()));
    }

    @Test
    public void executeDrawSegmentTest() {
        String command = "REPEAT 3 [ FORWARD 50 ]";
        LOGOExecutor.LOGO_EXECUTOR.execute(registry, env, new LinkedList<>(List.of(command.split(" "))));
        assertEquals(new Point(650, 500), env.getCursor().getPosition());
    }

    @Test
    public void commandWithoutParenthesisTest() {
        assertThrows(IllegalArgumentException.class, () -> {
                    String command = "REPEAT 3 [ FORWARD 50";
                    LOGOExecutor.LOGO_EXECUTOR.execute(registry, env, new LinkedList<>(List.of(command.split(" "))));
                }
        );
    }

    @Test
    public void executeDrawSquareTest() {
        String square = "REPEAT 4 [ FORWARD 50 RIGHT 90 ]";
        LOGOExecutor.LOGO_EXECUTOR.execute(registry, env, new LinkedList<>(List.of(square.split(" "))));
        assertEquals(new Point(500, 500), env.getCursor().getPosition());
    }

    @Test
    public void executeCommandAfterRepeatTest() {
        String square = "REPEAT 4 [ FORWARD 50 RIGHT 90 ] FORWARD 50";
        LOGOExecutor.LOGO_EXECUTOR.execute(registry, env, new LinkedList<>(List.of(square.split(" "))));
        assertEquals(new Point(550, 500), env.getCursor().getPosition());
    }

    @Test
    public void innerRepeatInstructionTest() {
        String script = "REPEAT 4 [ REPEAT 50 [ FORWARD 1 ] ]";
        LOGOExecutor.LOGO_EXECUTOR.execute(registry, env, new LinkedList<>(List.of(script.split(" "))));
        assertEquals(new Point(700, 500), env.getCursor().getPosition());
    }

    @Test
    public void secondInnerRepeatInstructionTest() {
        String script = "REPEAT 4 [ REPEAT 50 [ FORWARD 1 ] FORWARD 1 ]";
        LOGOExecutor.LOGO_EXECUTOR.execute(registry, env, new LinkedList<>(List.of(script.split(" "))));
        assertEquals(new Point(704, 500), env.getCursor().getPosition());
    }
}