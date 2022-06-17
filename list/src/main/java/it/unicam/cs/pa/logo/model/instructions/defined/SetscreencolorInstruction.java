package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione SETSCREENCOLOR, imposta il colore di background dell’area di disegno
 */
public final class SetscreencolorInstruction extends AbstractInstruction {
    public SetscreencolorInstruction() {
        super(3);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) {
        int red = getAttribute(script);
        int green = getAttribute(script);
        int blue = getAttribute(script);
        environment.setBackgroundColor(red, green, blue);
        return environment;
    }
}
