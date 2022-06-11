package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.model.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.defined.RepeatInstruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepeatInstructionTest {

    RepeatInstruction command;
    TwoDimEnvironment env;

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(1000, 1000);
        command = new RepeatInstruction(env);
    }

    @Test
    public void executeDrawSegmentTest() {
        command.accept(new LinkedList<>(List.of("3", "[", "FORWARD", "50", "]")));
        assertEquals(new TwoDimCoordinate(650, 500), env.getCursor().getPosition());
    }

    @Test
    public void commandWithoutParenthesis() {
        assertThrows(IllegalArgumentException.class, () ->
                command.accept(new LinkedList<>(List.of("3", "[", "FORWARD", "50"))));
    }
}