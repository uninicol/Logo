package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.io.InstructionLoader;
import it.unicam.cs.pa.logo.io.InstructionReader;
import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.defined.SimpleCursor;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BackwardInstructionTest {

    SimpleEnvironment env;
    InstructionReader<Instruction<SimpleEnvironment>, SimpleEnvironment> registry = InstructionLoader.DEFAULT_LOGO_READER;

    @BeforeEach
    void build() {
        env = new SimpleEnvironment(1000, 1000, new SimpleCursor(new Point(500, 500), new Direction360()));
    }

    @Test
    public void executeSimpleDrawSegmentTest() {
        String command = "BACKWARD 50";
        Instruction.LOGO_EXECUTOR.execute(registry, env, new LinkedList<>(List.of(command.split(" "))));
        assertEquals(new Point(450, 500), env.getCursor().getPosition());
        assertEquals(1, env.getPolygons().size());
    }

    @Test
    public void executeDrawSegmentTest() {
        String command = "BACKWARD -50";
        LinkedList<String> script = new LinkedList<>(List.of(command.split(" ")));
        Instruction.LOGO_EXECUTOR.execute(registry, env, script);
        assertEquals(new Point(550, 500), env.getCursor().getPosition());
        assertEquals(1, env.getPolygons().size());
    }

    @Test
    public void dontDrawOnlyMovesTest() {
        env.getCursor().setPlot(false);
        String command = "BACKWARD 50";
        Instruction.LOGO_EXECUTOR.execute(registry, env, new LinkedList<>(List.of(command.split(" "))));
        assertEquals(new Point(450, 500), env.getCursor().getPosition());
        assertTrue(env.getPolygons().isEmpty());
    }
}
