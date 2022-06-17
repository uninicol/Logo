package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione RIGHT, ruota il cursore in senso orario
 */
public final class RightInstruction extends AbstractInstruction {

    public RightInstruction() {
        super(1);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) {
        int grade = getAttribute(script);
        environment.getCursor().getDirection().increase(grade);
        return environment;
    }
}
