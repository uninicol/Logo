package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione PENDOWN, attacca la penna al foglio
 */
public final class PendownInstruction extends Instruction<Environment<?>> {
    public PendownInstruction(Environment<?> environment) {
        super(environment, 0);
    }

    @Override
    public Environment<?> apply(Queue<String> script) {
        getEnvironment().getCursor().setPlot(true);
        return getEnvironment();
    }

    @Override
    public String stringOf(Environment<?> environment) {
        return "attaccato la  penna al foglio";
    }
}
