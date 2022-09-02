package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione RIGHT, ruota il cursore in senso orario
 */
public final class RightInstruction implements Instruction<SimpleEnvironment> {

    @Override
    public String stringOf(SimpleEnvironment environment) {
        return "ruotato il cursore verso " + (int) environment.getCursor().getDirection().getValue();
    }

    @Override
    public SimpleEnvironment apply(SimpleEnvironment environment, Queue<String> script) {
        int grade = getIntegerAttribute(script);
        environment.getCursor().getDirection().increase(grade);
        return environment;
    }
}
