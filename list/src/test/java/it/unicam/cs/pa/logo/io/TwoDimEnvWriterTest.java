package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.InstructionExecutor;
import it.unicam.cs.pa.logo.model.instructions.InstructionRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class TwoDimEnvWriterTest {

    TwoDimEnvironment env;

    TwoDimEnvWriter writer;

    InstructionRegistry registry= InstructionRegistry.getTwoDimRegistrySet();

    TwoDimEnvWriterTest() throws IOException {
    }

    @BeforeEach
    void begin() {
        env = new TwoDimEnvironment(1000, 1000);
        //writer = new TwoDimEnvWriter(locationWriter);
    }

    @Test
    void stringOf()  {
        String command = "REPEAT 4 [ FORWARD 50 RIGHT 90 ]";
        new InstructionExecutor(registry, env ,command);
        System.out.println(writer.stringOf(env));
    }
}