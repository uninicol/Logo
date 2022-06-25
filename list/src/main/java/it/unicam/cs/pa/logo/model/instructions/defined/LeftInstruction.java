package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione LEFT, ruota il cursore in senso antiorario
 */
public final class LeftInstruction extends Instruction {
    public LeftInstruction() {
        super(1);
    }

    @Override
    public Environment apply(Environment environment, Queue<String> script) {
        int grade = getAttribute(script);
        environment.getCursor().getDirection().decrease(grade);
        return environment;
    }

    @Override
    public String stringOf(Environment environment) {
        return "ruotato il cursore nella direzione" + environment.getCursor().getDirection().getValue();
    }
}
