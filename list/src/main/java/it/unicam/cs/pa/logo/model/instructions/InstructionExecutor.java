package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.model.Environment;

import java.util.LinkedList;

public class InstructionExecutor implements Executor {

    private final Registry<Instruction> registry;

    private final Environment environment;

    private final LinkedList<String> script;

    public InstructionExecutor(Registry<Instruction> registry, Environment environment, LinkedList<String> script) {
        this.registry = registry;
        this.environment = environment;
        this.script = script;
    }

    @Override
    public Environment execute(String command) {
        return registry.get(command).apply(environment, script);
    }

    @Override
    public Environment execute(LinkedList<String> script) {
        while (!script.isEmpty())
            execute(script.poll());
        return environment;
    }
}
