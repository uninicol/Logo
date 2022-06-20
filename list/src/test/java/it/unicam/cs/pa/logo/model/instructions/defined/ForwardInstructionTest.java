package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.InstructionExecutor;
import it.unicam.cs.pa.logo.model.instructions.InstructionRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForwardInstructionTest {

    TwoDimEnvironment env;
    InstructionRegistry registry = InstructionRegistry.getTwoDimRegistrySet();
    InstructionExecutor executor;

    public ForwardInstructionTest() throws IOException {
    }

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);

    }

    @Test
    public void executeDrawSegmentTest() throws IOException {
        String command = "FORWARD 50";
        executor = new InstructionExecutor(registry, env, command);
        executor.executeScript();
        assertEquals(new TwoDimCoordinate(550, 500), env.getCursor().getPosition());
    }
}
