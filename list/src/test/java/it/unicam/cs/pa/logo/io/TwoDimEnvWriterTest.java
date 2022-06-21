package it.unicam.cs.pa.logo.io;

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

class TwoDimEnvWriterTest {

    TwoDimEnvironment env;

    TwoDimEnvWriter writer;

    InstructionRegistry registry= InstructionRegistry.getTwoDimRegistrySet();

    @BeforeEach
    void begin() {
        env = new TwoDimEnvironment(1000, 1000);
        //writer = new TwoDimEnvWriter(locationWriter);
    }

    @Test
    void stringOf() throws IOException {
        String command = "REPEAT 4 [ FORWARD 50 RIGHT 90 ] FORWARD 50";
        AbstractInstruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(command.split(" "))));
        assertEquals(new TwoDimCoordinate(550,500), env.getCursor().getPosition());
    }
}