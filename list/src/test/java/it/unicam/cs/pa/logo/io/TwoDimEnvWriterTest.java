package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.InstructionFactory;
import it.unicam.cs.pa.logo.model.instructions.TwoDimInstructionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class TwoDimEnvWriterTest {

    TwoDimEnvironment env;

    TwoDimEnvWriter writer;

    InstructionFactory<TwoDimEnvironment> factory;

    @BeforeEach
    void begin() {
        env = new TwoDimEnvironment(1000, 1000);
        //writer = new TwoDimEnvWriter(locationWriter);
        factory = new TwoDimInstructionFactory(env);
    }

    @Test
    void stringOf() throws IOException {
        String command = "REPEAT 4 [ FORWARD 50 RIGHT 90 ]";
        LinkedList<String> list = new LinkedList<>(List.of(command.split(" ")));
        factory.execute(list);
        String result="";
        System.out.println(writer.stringOf(env));
    }
}