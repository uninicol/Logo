package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Cursor;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione PENUP, stacca la penna dal foglio
 */
public final class PenupInstrucion extends Instruction<Environment<Cursor>> {
    public PenupInstrucion(Environment<Cursor> environment) {
        super(environment, 0);
    }

    @Override
    public Environment<Cursor> apply(Queue<String> script) {
        getEnvironment().getCursor().setPlot(false);
        return getEnvironment();
    }

    @Override
    public String stringOf(Environment<Cursor> environment) {
        return "staccato la penna al foglio";
    }
}
