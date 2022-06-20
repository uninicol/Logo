package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.model.Environment;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class InstructionExecutor {

    private final Registry<AbstractInstruction> registry;

    private Environment environment;

    private final LinkedList<String> script;

    public InstructionExecutor(Registry<AbstractInstruction> registry, Environment environment, String script) {
        this.registry = Objects.requireNonNull(registry);
        this.environment = Objects.requireNonNull(environment);
        Objects.requireNonNull(script);
        this.script = new LinkedList<>(List.of(script.split(" ")));
    }

    public InstructionExecutor(Registry<AbstractInstruction> registry, Environment environment, LinkedList<String> script) {
        this.registry = Objects.requireNonNull(registry);
        this.environment = Objects.requireNonNull(environment);
        this.script = Objects.requireNonNull(script);
    }

//    public <E> InstructionExecutor(TwoDimRegistry twoDimRegistry, Environment environment, LinkedList<E> es) {
//
//    }

    public Environment executeScript() throws IOException {
        while (!script.isEmpty()) {
            String command=script.peek();
            this.environment = execute(script.poll());
            registry.get(command).stringOf(this.environment);
        }
        return environment;
    }

    private Environment execute(String command) throws IOException {
        return registry.get(command).apply(environment, script);
    }
}
