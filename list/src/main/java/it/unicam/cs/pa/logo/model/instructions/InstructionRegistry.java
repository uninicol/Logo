package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionReader;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class InstructionRegistry implements Registry<Instruction> {

    private static final InstructionReader<Instruction> READER = InstructionRegistry::fromString;

    private static Instruction fromString(Registry<Instruction> registry, String str) {
        return registry.get(str);
    }

    private final Map<String, Instruction> instructionMap = new HashMap<>();
    private final Function<String, Instruction> factoryFunction;

    public InstructionRegistry(Function<String, Instruction> factoryFunction) {
        this.factoryFunction = factoryFunction;//TODO sostituire con la funzione che interpreta i comandi
        createInstruction("FORWARD");
        createInstruction("BACKWARD");
        createInstruction("LEFT");
        createInstruction("RIGHT");
        createInstruction("CLEARSCREEN");
        createInstruction("HOME");
        createInstruction("PENUP");
        createInstruction("PENDOWN");
        createInstruction("SETPENCOLOR");
        createInstruction("SETFILLCOLOR");
        createInstruction("SETSCREENCOLOR");
        createInstruction("SETPENSIZE");
        createInstruction("REPEAT");
    }

    @Override
    public Instruction createInstruction(String name) {
        Instruction instruction = factoryFunction.apply(name);
        instructionMap.put(name, instruction);
        return instruction;
    }

    @Override
    public Instruction get(String name) {
        return instructionMap.get(name);
    }
}
