package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione SETPENSIZE, indica la grandezza del tratto della penna
 */
public final class SetpensizeInstruction extends AbstractInstruction {
    public SetpensizeInstruction() {
        super(1);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) {
        environment.getCursor().setSize(getAttribute(script));
        return environment;
    }
}
