package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionReader;
import it.unicam.cs.pa.logo.io.InstructionWriter;
import it.unicam.cs.pa.logo.io.TwoDimInstructionLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Registro per contenere il set di istruzioni che andremo ad utilizzare
 */
public class InstructionRegistry implements Registry<AbstractInstruction> {

    private final Map<String, AbstractInstruction> instructionMap = new HashMap<>();
    private static InstructionReader<AbstractInstruction> factoryFunction;

    public InstructionRegistry(InstructionReader<AbstractInstruction> factoryFunction) {
        InstructionRegistry.factoryFunction = factoryFunction;
    }

    @Override
    public AbstractInstruction createInstruction(String name) {
        AbstractInstruction instruction = factoryFunction.parse(name);
        instructionMap.put(name, instruction);
        return instruction;
    }

    @Override
    public AbstractInstruction get(String name) {
        return instructionMap.get(name);
    }

    /**
     * Inserisce nel registry il set di istruzioni LOGO
     *
     * @return il registro con i comandi
     */
    public static InstructionRegistry getTwoDimRegistrySet() {
        InstructionRegistry registry = new InstructionRegistry(TwoDimInstructionLoader.READER);
        List<String> instructions = List.of("BACKWARD", "CLEARSCREEN", "FORWARD", "HOME", "LEFT", "PENDOWN", "PENUP",
                "REPEAT", "RIGHT", "SETFILLCOLOR", "SETPENCOLOR", "SETPENSIZE", "SETSCREENCOLOR");
        instructions.forEach(registry::createInstruction);
        return registry;
    }
}
