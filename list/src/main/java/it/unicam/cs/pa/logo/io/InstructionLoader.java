package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Environment;
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
    public static InstructionReader<Instruction<Environment<?>>, Environment<?>> DEFAULT_LOGO_READER = ((str, env) ->
            switch (str) {
                case "BACKWARD" -> Optional.of(new BackwardInstruction(env));
                case "LEFT" -> Optional.of(new LeftInstruction(env));
                case "RIGHT" -> Optional.of(new RightInstruction(env));
                case "CLEARSCREEN" -> Optional.of(new ClearscreenInstruction(env));
                case "HOME" -> Optional.of(new HomeInstruction(env));
                case "PENUP" -> Optional.of(new PenupInstrucion(env));
                case "PENDOWN" -> Optional.of(new PendownInstruction(env));
                case "SETPENCOLOR" -> Optional.of(new SetpencolorInstruction(env));
                case "SETFILLCOLOR" -> Optional.of(new SetfillcolorInstruction(env));
                case "SETSCREENCOLOR" -> Optional.of(new SetscreencolorInstruction(env));
                case "SETPENSIZE" -> Optional.of(new SetpensizeInstruction(env));
                case "REPEAT" -> Optional.of(new RepeatInstruction(env));
                case "FORWARD" -> Optional.of(new ForwardInstruction(env));
                default -> Optional.empty();
            }
    );
}
