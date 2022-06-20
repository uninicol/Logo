package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionReader;
import it.unicam.cs.pa.logo.io.TwoDimInstructionLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Registro per contenere il set di istruzioni che andremo ad utilizzare
 */
public class InstructionRegistry implements Registry<AbstractInstruction> {

    //private abstract final InstructionReader<AbstractInstruction> READER = InstructionRegistry::fromString;

    private final Map<String, AbstractInstruction> instructionMap = new HashMap<>();
    private final InstructionReader<AbstractInstruction> factoryFunction;

    public InstructionRegistry(InstructionReader<AbstractInstruction> factoryFunction) {
        this.factoryFunction = factoryFunction;
    }

    @Override
    public AbstractInstruction createInstruction(String name) throws IOException {
        AbstractInstruction instruction = factoryFunction.parse(name);
        instructionMap.put(name, instruction);
        return instruction;
    }

    @Override
    public AbstractInstruction get(String name) {
        return instructionMap.get(name);
    }

    public static InstructionRegistry getTwoDimRegistrySet() throws IOException {
        InstructionRegistry registry =new InstructionRegistry(name -> new TwoDimInstructionLoader().parse(name));
        registry.createInstruction("BACKWARD");
        registry.createInstruction("CLEARSCREEN");
        registry.createInstruction("FORWARD");
        registry.createInstruction("HOME");
        registry.createInstruction("LEFT");
        registry.createInstruction("PENDOWN");
        registry.createInstruction("PENUP");
        registry.createInstruction("REPEAT");
        registry.createInstruction("RIGHT");
        registry.createInstruction("SETFILLCOLOR");
        registry.createInstruction("SETPENCOLOR");
        registry.createInstruction("SETPENSIZE");
        registry.createInstruction("SETSCREENCOLOR");
        return registry;
    }
}
