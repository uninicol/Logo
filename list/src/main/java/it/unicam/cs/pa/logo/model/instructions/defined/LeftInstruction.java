package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione LEFT, ruota il cursore in senso antiorario
 */
public final class LeftInstruction extends Instruction<SimpleEnvironment> {
    public LeftInstruction(SimpleEnvironment environment) {
        super(environment, 1);
    }

    @Override
    public SimpleEnvironment apply(Queue<String> script) {
        int grade = getAttribute(script);
        getEnvironment().getCursor().getDirection().decrease(grade);
        return getEnvironment();
    }

    @Override
    public String stringOf(SimpleEnvironment environment) {
        return "ruotato il cursore nella direzione " + environment.getCursor().getDirection().getValue();
    }
}
