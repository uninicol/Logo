package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione RIGHT, ruota il cursore in senso orario
 */
public final class RightInstruction extends Instruction<Environment> {

    public RightInstruction(Environment environment) {
        super(environment, 1);
    }

    @Override
    public Environment apply(Queue<String> script) {
        int grade = getAttribute(script);
        getEnvironment().getCursor().getDirection().increase(grade);
        return getEnvironment();
    }

    @Override
    public String stringOf(Environment environment) {
        return "ruotato il cursore verso " + environment.getCursor().getDirection().getValue();
    }
}
