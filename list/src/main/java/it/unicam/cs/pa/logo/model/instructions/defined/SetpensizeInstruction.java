package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione SETPENSIZE, indica la grandezza del tratto della penna
 */
public final class SetpensizeInstruction implements Instruction<SimpleEnvironment> {

    @Override
    public String stringOf(SimpleEnvironment environment) {
        return "impostato la grandezza del tratto in " + environment.getCursor().getSize();
    }

    @Override
    public SimpleEnvironment apply(SimpleEnvironment environment, Queue<String> script) {
        environment.getCursor().setSize(getIntegerAttribute(script));
        return environment;
    }
}
