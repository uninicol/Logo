package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione HOME, muove il cursore nella posizione di home
 */
public final class HomeInstruction extends AbstractInstruction {
    public HomeInstruction() {
        super(0);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) {
        environment.getCursor().move(environment.getHome());
        return environment;
    }

    @Override
    public String stringOf(Environment environment) {
        return "Spostato il cursore nella posizione di home" + environment.getCursor().getPosition();
    }
}
