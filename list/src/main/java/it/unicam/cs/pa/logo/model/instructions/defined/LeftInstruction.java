package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione LEFT, ruota il cursore in senso antiorario
 */
public final class LeftInstruction implements Instruction<SimpleEnvironment> {

    @Override
    public String stringOf(SimpleEnvironment environment) {
        return "ruotato il cursore nella direzione " + environment.getCursor().getDirection().getValue();
    }

    @Override
    public SimpleEnvironment apply(SimpleEnvironment environment, Queue<String> script) {
        int grade = getIntegerAttribute(script);
        environment.getCursor().getDirection().decrease(grade);
        return environment;
    }
}
