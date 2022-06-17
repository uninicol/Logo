package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.awt.*;
import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione SETPENCOLOR, imposta il colore della penna
 */
public final class SetpencolorInstruction extends AbstractInstruction {
    public SetpencolorInstruction() {
        super(3);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) {
        int red = getAttribute(script);
        int green = getAttribute(script);
        int blue = getAttribute(script);
        environment.getCursor().setLineColor(
                new Color(
                        red, green, blue
                )
        );
        return environment;
    }
}
