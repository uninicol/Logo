package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.defined.*;

/**
 * Factory usata per interpretare ed eseguire istruzioni che operano in un ambiente bidimensionale
 */
public class TwoDimInstructionFactory extends InstructionFactory<TwoDimEnvironment> {

    public TwoDimInstructionFactory(TwoDimEnvironment environment) {
        super(environment);
    }

    @Override
    public Instruction<TwoDimEnvironment> createInstruction(String instructionName, TwoDimEnvironment environment) {
        Instruction<TwoDimEnvironment> instruction = nameMatch(instructionName, environment);
        if (instruction == null) throw new IllegalArgumentException("Comando non trovato");
        return instruction;
    }

    /**
     * Restituisce la classe corrispondente al nome del comando
     *
     * @param instructionName il nome del comando
     * @param environment     l'environment su cui opera il comando
     * @return la classe corrispondente al nome del comando
     */
    private Instruction<TwoDimEnvironment> nameMatch(String instructionName, TwoDimEnvironment environment) {
        return switch (instructionName) {
            case "FORWARD" -> new ForwardInstruction(environment);
            case "BACKWARD" -> new BackwardInstruction(environment);
            case "LEFT" -> new LeftInstruction(environment);
            case "RIGHT" -> new RightInstruction(environment);
            case "CLEARSCREEN" -> new ClearscreenInstruction(environment);
            case "HOME" -> new HomeInstruction(environment);
            case "PENUP" -> new PenupInstrucion(environment);
            case "PENDOWN" -> new PendownInstruction(environment);
            case "SETPENCOLOR" -> new SetpencolorInstruction(environment);
            case "SETFILLCOLOR" -> new SetfillcolorInstruction(environment);
            case "SETSCREENCOLOR" -> new SetscreencolorInstruction(environment);
            case "SETPENSIZE" -> new SetpensizeInstruction(environment);
            case "RIPETI" -> new RepeatInstruction(environment);
            default -> getAddedInstructionMap().get(instructionName);
        };
    }
}
