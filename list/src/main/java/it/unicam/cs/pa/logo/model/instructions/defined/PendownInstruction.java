package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione PENDOWN, attacca la penna al foglio
 */
public final class PendownInstruction extends Instruction {
    public PendownInstruction() {
        super(0);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) {
        environment.getCursor().setPlot(true);
        return environment;
    }

    @Override
    public String stringOf(Environment environment) {
        return "attaccato la  penna al foglio";
    }
}
