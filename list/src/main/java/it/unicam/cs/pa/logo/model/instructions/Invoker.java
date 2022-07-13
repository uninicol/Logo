package it.unicam.cs.pa.logo.model.instructions;

import java.util.Queue;

public final class Invoker<I extends Instruction<?>> {

    private I instruction;

    public void setInstruction(I instruction) {
        this.instruction = instruction;
    }

    public void executeInstruction(Queue<String> script) {
        instruction.apply(script);
    }
}
