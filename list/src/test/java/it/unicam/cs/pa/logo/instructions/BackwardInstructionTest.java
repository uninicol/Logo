package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.TwoDimCoordinate;
import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.defined.BackwardInstruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackwardInstructionTest {

    BackwardInstruction command;
    TwoDimEnvironment env;

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);
        command = new BackwardInstruction(env);
    }

    @Test
    public void executeDrawSegmentTest() {
        command.execute(List.of(50));
        assertEquals(new TwoDimCoordinate(450, 500), env.getCursor().getPosition());
    }
}
