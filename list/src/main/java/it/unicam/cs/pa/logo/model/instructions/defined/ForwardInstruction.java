package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione FORWARD, sposta il cursore in avanti verso la sua direzione
 */
public final class ForwardInstruction extends AbstractInstruction {

    public ForwardInstruction() {
        super(1);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) {
        int length = getAttribute(script);
        //determino il punto di arrivo con dovuti limiti
        return environment.getDrawer().drawLine(length);
    }
}