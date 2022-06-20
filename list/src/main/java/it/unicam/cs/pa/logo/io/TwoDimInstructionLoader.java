package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import it.unicam.cs.pa.logo.model.instructions.Registry;
import it.unicam.cs.pa.logo.model.instructions.defined.*;

import java.io.IOException;

public class TwoDimInstructionLoader implements InstructionReader<AbstractInstruction> {

    @Override
    public  AbstractInstruction parse(String str) {
        return switch (str){
            case "BACKWARD"->new BackwardInstruction();
            case "LEFT"-> new LeftInstruction();
            case "RIGHT"-> new RightInstruction();
            case "CLEARSCREEN"-> new ClearscreenInstruction();
            case "HOME"-> new HomeInstruction();
            case "PENUP"-> new PenupInstrucion();
            case "PENDOWN"-> new PendownInstruction();
            case "SETPENCOLOR"-> new SetpencolorInstruction();
            case "SETFILLCOLOR"-> new SetfillcolorInstruction();
            case "SETSCREENCOLOR"-> new SetscreencolorInstruction();
            case "SETPENSIZE"-> new SetpensizeInstruction();
            case "REPEAT"-> new RepeatInstruction();
            case "FORWARD"->new ForwardInstruction();
            default -> throw new IllegalArgumentException("Comando non presente");
        };
    }
}
