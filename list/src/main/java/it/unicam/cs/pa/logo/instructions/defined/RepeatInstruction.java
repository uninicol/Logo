package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;
import it.unicam.cs.pa.logo.instructions.TwoDimInstructionFactory;

import java.util.Deque;
import java.util.LinkedList;

public final class RepeatInstruction extends AbstractInstruction<TwoDimEnvironment> {

    public RepeatInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void accept(Deque<String> instruction) {
        int num = getAttribute(instruction);
        instruction.poll(); //elimino la prima parentesi quadrata
        //creo una Deque delle istruzioni da ripetere (a quanto pare non posso utilizzare stream con Deque)
        Deque<String> toRepeat = new LinkedList<>();
        if (instruction.stream().noneMatch(str -> str.equals("]")))
            throw new IllegalArgumentException("Mancata parentesi quadrata di chiusura");
        while (!instruction.peek().equals("]")) {
            toRepeat.add(instruction.poll());
        }
        instruction.poll(); //elimino la seconda parentesi quadrata
        for (int i = 0; i < num; i++) {
            new TwoDimInstructionFactory(getEnvironment()).execute(new LinkedList<>(toRepeat));
        }
    }
}