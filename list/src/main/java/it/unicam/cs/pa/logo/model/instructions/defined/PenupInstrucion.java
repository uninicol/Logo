package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione PENUP, stacca la penna dal foglio
 */
public final class PenupInstrucion extends Instruction<Environment> {
    public PenupInstrucion(Environment environment) {
        super(environment, 0);
    }

    @Override
    public Environment apply(Queue<String> script) {
        getEnvironment().getCursor().setPlot(false);
        return getEnvironment();
    }

    @Override
    public String stringOf(Environment environment) {
        return "staccato la penna al foglio";
    }
}
