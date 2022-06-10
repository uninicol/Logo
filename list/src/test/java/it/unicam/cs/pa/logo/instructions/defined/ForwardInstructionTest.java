package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimCoordinate;
import it.unicam.cs.pa.logo.TwoDimEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForwardInstructionTest {

    ForwardInstruction command;
    TwoDimEnvironment env;

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);
        command = new ForwardInstruction(env);
    }

    @Test
    public void executeDrawSegmentTest() {
        command.accept(new LinkedList<>(List.of("50")));
        assertEquals(new TwoDimCoordinate(550, 500), env.getCursor().getPosition());
    }
}
