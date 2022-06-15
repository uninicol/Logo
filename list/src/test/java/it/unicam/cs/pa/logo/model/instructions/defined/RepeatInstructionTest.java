package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
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
    public void commandWithoutParenthesisTest() {
        assertThrows(IllegalArgumentException.class, () ->
                command.accept(new LinkedList<>(List.of("3", "[", "FORWARD", "50"))));
    }

    @Test
    public void executeDrawSquareTest() {
        String square = "4 [ FORWARD 50 RIGHT 90 ]";
        command.accept(new LinkedList<>(List.of(square.split(" "))));
        assertEquals(new TwoDimCoordinate(500, 500), env.getCursor().getPosition());
    }
}