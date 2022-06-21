package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionWriter;

/**
 * Classe astratta che contiene gli attributi di un istruzione
 */
public abstract class AbstractInstruction implements Instruction, InstructionWriter {

    public static final Executor<AbstractInstruction> EXECUTOR = (registry, environment, script) -> {
        while (!script.isEmpty()) {
            String command = script.poll();
            if (command.equals("]")) break;
            environment = registry.get(command).apply(environment, script);
            System.out.println(command + " ha " + registry.get(command).stringOf(environment));
        }
        return environment;
    };


    private final int numOfAttributes;
    private int requestedAttributes;

    public AbstractInstruction(int numOfAttributes) {
        this.numOfAttributes = numOfAttributes;
        this.requestedAttributes = 0;
    }

    @Override
    public final int getRequiredAttributesNumber() {
        return numOfAttributes;
    }

    @Override
    public final int getRequestedAttributesNumber() {
        return requestedAttributes;
    }

    @Override
    public final void setRequestedAttributesNumber(int number) {
        this.requestedAttributes = number;
    }
}