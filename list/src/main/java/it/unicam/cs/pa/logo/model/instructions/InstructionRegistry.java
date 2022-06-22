package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionReader;
import it.unicam.cs.pa.logo.io.TwoDimInstructionLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Registro per contenere il set di istruzioni che andremo ad utilizzare
 */
public class InstructionRegistry implements Registry<Instruction> {

    private static InstructionReader<Instruction> factoryFunction;
    private final Map<String, Function<String, Instruction>> instructionMap = new HashMap<>();

    public InstructionRegistry(InstructionReader<Instruction> factoryFunction) {
        InstructionRegistry.factoryFunction = factoryFunction;
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

    @Override
    public Function<String, Instruction> createInstruction(String name) {
        Function<String, Instruction> instruction = factoryFunction.parse(name);
        instructionMap.put(name, instruction);
        return instruction;
    }

    @Override
    public Function<String, Instruction> get(String name) {
        return instructionMap.get(name);
    }
}
