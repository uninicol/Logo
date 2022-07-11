package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Cursor;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione RIGHT, ruota il cursore in senso orario
 */
public final class RightInstruction extends Instruction<Environment<Cursor>> {

    public RightInstruction(Environment<Cursor> environment) {
        super(environment, 1);
    }

    @Override
    public Environment<Cursor> apply(Queue<String> script) {
        int grade = getAttribute(script);
        getEnvironment().getCursor().getDirection().increase(grade);
        return getEnvironment();
    }

    @Override
    public String stringOf(Environment<Cursor> environment) {
        return "ruotato il cursore verso " + (int) environment.getCursor().getDirection().getValue();
    }
}
