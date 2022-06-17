package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione BACKWARD, sposta il cursore indietro rispetto la sua direzione
 */
public final class BackwardInstruction extends AbstractInstruction {

    public BackwardInstruction() {
        super(1);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) {
        int length = -getAttribute(script);
        return environment.getDrawer().drawLine(length);
    }
}