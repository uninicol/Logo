package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.instructions.Executor;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import it.unicam.cs.pa.logo.model.instructions.Registry;

public class TwoDimInstructionLoader implements InstructionReader<Instruction> {

    Executor executor;

    @Override
    public Instruction parse(Registry<Instruction> registry, String str) {
        return null;
    }
}
