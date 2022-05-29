package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.TwoDimInstructionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ClearscreenInstructionTest {
    ClearscreenInstruction instruction;
    TwoDimEnvironment env;

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(100, 100);
        instruction = new ClearscreenInstruction(env);
    }

    @Test
    void clearScreen() {
        TwoDimInstructionFactory factory=new TwoDimInstructionFactory(env);
        factory.execute(new LinkedList<>(List.of("FORWARD","50")));
        assertFalse(env.getShapes().isEmpty());
        factory.execute(new LinkedList<>(List.of("CLEARSCREEN")));
        assertTrue(env.getShapes().isEmpty());
    }

}