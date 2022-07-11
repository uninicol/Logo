package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Cursor;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione CLEARSCREEN, cancella quanto disegnato
 */
public final class ClearscreenInstruction extends Instruction<Environment<Cursor>> {
    public ClearscreenInstruction(Environment<Cursor> environment) {
        super(environment, 0);
    }

    @Override
    public Environment<Cursor> apply(Queue<String> script) {
        getEnvironment().clearAll();
        return getEnvironment();
    }

    @Override
    public String stringOf(Environment<Cursor> environment) {
        return "cancellato le linee tracciate";
    }
}
