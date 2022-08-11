package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionReader;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;

import java.util.Queue;

public class LOGOExecutor implements Executor<Instruction<SimpleEnvironment>, SimpleEnvironment> {

    //private final List<SimpleEnvironment> updates = new LinkedList<>();

    @Override
    public SimpleEnvironment execute(InstructionReader<Instruction<SimpleEnvironment>, SimpleEnvironment> registry, SimpleEnvironment environment, Queue<String> script) {
        while (!script.isEmpty()) {
            registry.parse(script.poll(), environment)
                    .ifPresent(instruction -> {
                        instruction.apply(script);
                        System.out.println(instruction.stringOf(environment));
                    });
        }
        return environment;
    }
}
