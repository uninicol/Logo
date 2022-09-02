package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import it.unicam.cs.pa.logo.model.instructions.defined.*;

import java.util.Optional;

/**
 * Questa classe contiene metodi che contengono dei set di istruzioni
 */
public class InstructionLoader {

    /**
     * Lista di funzioni che creano un istruzione del linguaggio LOGO
     */
    public static InstructionReader<Instruction<SimpleEnvironment>> DEFAULT_LOGO_READER = (str ->
            switch (str) {
                case "BACKWARD" -> Optional.of(new BackwardInstruction());
                case "LEFT" -> Optional.of(new LeftInstruction());
                case "RIGHT" -> Optional.of(new RightInstruction());
                case "CLEARSCREEN" -> Optional.of(new ClearscreenInstruction());
                case "HOME" -> Optional.of(new HomeInstruction());
                case "PENUP" -> Optional.of(new PenupInstrucion());
                case "PENDOWN" -> Optional.of(new PendownInstruction());
                case "SETPENCOLOR" -> Optional.of(new SetpencolorInstruction());
                case "SETFILLCOLOR" -> Optional.of(new SetfillcolorInstruction());
                case "SETSCREENCOLOR" -> Optional.of(new SetscreencolorInstruction());
                case "SETPENSIZE" -> Optional.of(new SetpensizeInstruction());
                case "REPEAT" -> Optional.of(new RepeatInstruction());
                case "FORWARD" -> Optional.of(new ForwardInstruction());
                default -> Optional.empty();
            }
    );
}
