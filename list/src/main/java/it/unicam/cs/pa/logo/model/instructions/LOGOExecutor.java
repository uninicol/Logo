package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;

public class LOGOExecutor {

    public static Executor<Instruction<SimpleEnvironment>, SimpleEnvironment> LOGO_EXECUTOR = ((registry, environment, script) -> {
        while (!script.isEmpty()) {
            registry.parse(script.poll())
                    .ifPresent(instruction -> {
                        instruction.apply(environment, script);
                        System.out.println(instruction.stringOf(environment));
                    });
        }
        return environment;
    });
}
