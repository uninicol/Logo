package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione LEFT, ruota il cursore in senso antiorario
 */
public final class LeftInstruction extends AbstractInstruction {
    public LeftInstruction() {
        super(1);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) {
        int grade = -getAttribute(script);
        environment.getCursor().getDirection().increase(grade);
        return environment;
    }

    @Override
    public String stringOf(Environment environment) {
        return "Ruotato il cursore nella direzione" + environment.getCursor().getDirection().getValue();
    }
}
