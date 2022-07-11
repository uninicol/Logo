package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.defined.Cursor;
import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.defined.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoDimEnvWriterTest {

    Environment env;

    SimpleEnvWriter writer;

    InstructionReader<Instruction<Environment>, Environment> registry = InstructionLoader.DEFAULT_LOGO_READER;

    @BeforeEach
    void begin() {
        env = new Environment(1000, 1000, new Cursor(new Point(500, 500), new Direction360()));
        //writer = new TwoDimEnvWriter(locationWriter);
    }

    @Test
    void stringOf() {
        String command = "REPEAT 4 [ FORWARD 50 RIGHT 90 ] FORWARD 50";
        Instruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(command.split(" "))));
        assertEquals(new Point(550, 500), env.getCursor().getPosition());
    }
}