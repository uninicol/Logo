package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Cursor;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione LEFT, ruota il cursore in senso antiorario
 */
public final class LeftInstruction extends Instruction<Environment<Cursor>> {
    public LeftInstruction(Environment<Cursor> environment) {
        super(environment, 1);
    }

    @Override
    public Environment<Cursor> apply(Queue<String> script) {
        int grade = getAttribute(script);
        getEnvironment().getCursor().getDirection().decrease(grade);
        return getEnvironment();
    }

    @Override
    public String stringOf(Environment<Cursor> environment) {
        return "ruotato il cursore nella direzione" + (int) environment.getCursor().getDirection().getValue();
    }
}
