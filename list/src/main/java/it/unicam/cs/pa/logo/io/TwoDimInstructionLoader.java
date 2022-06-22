package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.instructions.Instruction;
import it.unicam.cs.pa.logo.model.instructions.defined.*;

public class TwoDimInstructionLoader {
    public static InstructionReader<Instruction> READER = (str -> switch (str) {
        case "BACKWARD" -> (name) -> new BackwardInstruction();
        case "LEFT" -> (name) -> new LeftInstruction();
        case "RIGHT" -> (name) -> new RightInstruction();
        case "CLEARSCREEN" -> (name) -> new ClearscreenInstruction();
        case "HOME" -> (name) -> new HomeInstruction();
        case "PENUP" -> (name) -> new PenupInstrucion();
        case "PENDOWN" -> (name) -> new PendownInstruction();
        case "SETPENCOLOR" -> (name) -> new SetpencolorInstruction();
        case "SETFILLCOLOR" -> (name) -> new SetfillcolorInstruction();
        case "SETSCREENCOLOR" -> (name) -> new SetscreencolorInstruction();
        case "SETPENSIZE" -> (name) -> new SetpensizeInstruction();
        case "REPEAT" -> (name) -> new RepeatInstruction();
        case "FORWARD" -> (name) -> new ForwardInstruction();
        default -> null;
    }
    );
}
