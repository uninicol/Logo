package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione SETPENSIZE, indica la grandezza del tratto della penna
 */
public final class SetpensizeInstruction extends Instruction<SimpleEnvironment> {
    public SetpensizeInstruction(SimpleEnvironment environment) {
        super(environment, 1);
    }

    @Override
    public SimpleEnvironment apply(Queue<String> script) {
        getEnvironment().getCursor().setSize(getAttribute(script));
        return getEnvironment();
    }


    @Override
    public String stringOf(SimpleEnvironment environment) {
        return "impostato la grandezza del tratto in " + environment.getCursor().getSize();
    }
}
