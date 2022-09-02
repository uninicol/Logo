package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione PENUP, stacca la penna dal foglio
 */
public final class PenupInstrucion implements Instruction<SimpleEnvironment> {

    @Override
    public String stringOf(SimpleEnvironment environment) {
        return "staccato la penna al foglio";
    }

    @Override
    public SimpleEnvironment apply(SimpleEnvironment environment, Queue<String> script) {
        environment.getCursor().setPlot(false);
        return environment;
    }
}
