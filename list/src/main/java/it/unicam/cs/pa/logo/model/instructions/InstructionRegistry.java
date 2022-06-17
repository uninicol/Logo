package it.unicam.cs.pa.logo.model.instructions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class InstructionRegistry<I extends Instruction> implements Registry<I> {

    private final Map<String, I> instructionMap = new HashMap<>();
    private final Function<String, I> factoryFunction;

    public InstructionRegistry(Function<String, I> factoryFunction) {
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
    public I createInstruction(String name) {
        I instruction = factoryFunction.apply(name);
        instructionMap.put(name, instruction);
        return instruction;
    }

    @Override
    public I get(String name) {
        return instructionMap.get(name);
    }
}
