package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.io.InstructionLoader;
import it.unicam.cs.pa.logo.io.InstructionReader;
import it.unicam.cs.pa.logo.model.Cursor;
import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForwardInstructionTest {

    Environment<Cursor> env;
    InstructionReader<Instruction<Environment<Cursor>>, Environment<Cursor>> registry = InstructionLoader.DEFAULT_LOGO_READER;

    @BeforeEach
    void build() {
        env = new Environment<>(1000, 1000, new Cursor(new Point(500, 500), new Direction360()));
    }

    @Test
    public void executeDrawSegmentTest() {
        String command = "FORWARD 50";
        Instruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(command.split(" "))));
        assertEquals(new Point(550, 500), env.getCursor().getPosition());
    }
}
