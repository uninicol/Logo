package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione PENUP, stacca la penna dal foglio
 */
public final class PenupInstrucion extends Instruction<SimpleEnvironment> {
    public PenupInstrucion(SimpleEnvironment environment) {
        super(environment, 0);
    }

    @Override
    public SimpleEnvironment apply(Queue<String> script) {
        getEnvironment().getCursor().setPlot(false);
        return getEnvironment();
    }

    @Override
    public String stringOf(SimpleEnvironment environment) {
        return "staccato la penna al foglio";
    }
}
