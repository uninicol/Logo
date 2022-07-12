package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import it.unicam.cs.pa.logo.model.instructions.defined.*;

/**
 * Questa classe contiene metodi che contengono dei set di istruzioni
 */
public class InstructionLoader {

    /**
     * Lista di funzioni che creano un istruzione del linguaggio LOGO
     */
    public static InstructionReader<Instruction<Environment<?>>, Environment<?>> DEFAULT_LOGO_READER = ((str, env) ->
            switch (str) {
                case "BACKWARD" -> new BackwardInstruction(env);
                case "LEFT" -> new LeftInstruction(env);
                case "RIGHT" -> new RightInstruction(env);
                case "CLEARSCREEN" -> new ClearscreenInstruction(env);
                case "HOME" -> new HomeInstruction(env);
                case "PENUP" -> new PenupInstrucion(env);
                case "PENDOWN" -> new PendownInstruction(env);
                case "SETPENCOLOR" -> new SetpencolorInstruction(env);
                case "SETFILLCOLOR" -> new SetfillcolorInstruction(env);
                case "SETSCREENCOLOR" -> new SetscreencolorInstruction(env);
                case "SETPENSIZE" -> new SetpensizeInstruction(env);
                case "REPEAT" -> new RepeatInstruction(env);
                case "FORWARD" -> new ForwardInstruction(env);
                default -> null;
            }
    );
}
