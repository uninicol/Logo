package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione RIGHT, ruota il cursore in senso orario
 */
public final class RightInstruction extends Instruction<SimpleEnvironment> {

    public RightInstruction(SimpleEnvironment environment) {
        super(environment, 1);
    }

    @Override
    public SimpleEnvironment apply(Queue<String> script) {
        int grade = getAttribute(script);
        getEnvironment().getCursor().getDirection().increase(grade);
        return getEnvironment();
    }

    @Override
    public String stringOf(SimpleEnvironment environment) {
        return "ruotato il cursore verso " + (int) environment.getCursor().getDirection().getValue();
    }
}
