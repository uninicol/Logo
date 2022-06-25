package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione RIGHT, ruota il cursore in senso orario
 */
public final class RightInstruction extends Instruction {

    public RightInstruction() {
        super(1);
    }

    @Override
    public Environment apply(Environment environment, Queue<String> script) {
        int grade = getAttribute(script);
        environment.getCursor().getDirection().increase(grade);
        return environment;
    }

    @Override
    public String stringOf(Environment environment) {
        return "ruotato il cursore verso " + environment.getCursor().getDirection().getValue();
    }
}
