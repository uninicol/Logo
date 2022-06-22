package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import it.unicam.cs.pa.logo.model.instructions.InstructionRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForwardInstructionTest {

    TwoDimEnvironment env;
    InstructionRegistry registry = InstructionRegistry.getTwoDimRegistrySet();

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);

    }

    @Test
    public void executeDrawSegmentTest() throws IOException {
        String command = "FORWARD 50";
        Instruction.EXECUTOR.execute(registry, env, new LinkedList<>(List.of(command.split(" "))));
        assertEquals(new TwoDimCoordinate(550, 500), env.getCursor().getPosition());
    }
}
