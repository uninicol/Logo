package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione PENUP, stacca la penna dal foglio
 */
public final class PenupInstrucion extends Instruction {
    public PenupInstrucion() {
        super(0);
    }

    @Override
    public Environment apply(Environment environment, Queue<String> script) {
        environment.getCursor().setPlot(false);
        return environment;
    }

    @Override
    public String stringOf(Environment environment) {
        return "staccato la penna al foglio";
    }
}
