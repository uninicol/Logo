package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione PENDOWN, attacca la penna al foglio
 */
public final class PendownInstruction extends Instruction<SimpleEnvironment> {
    public PendownInstruction(SimpleEnvironment environment) {
        super(environment, 0);
    }

    @Override
    public SimpleEnvironment apply(Queue<String> script) {
        getEnvironment().getCursor().setPlot(true);
        return getEnvironment();
    }

    @Override
    public String stringOf(SimpleEnvironment environment) {
        return "attaccato la  penna al foglio";
    }
}
