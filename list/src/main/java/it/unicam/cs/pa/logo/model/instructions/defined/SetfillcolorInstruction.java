package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;

import java.awt.*;
import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione SETFILLCOLOR, imposta il colore del riempimento di un’area chiusa
 */
public final class SetfillcolorInstruction extends AbstractInstruction {

    public SetfillcolorInstruction() {
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

    @Override
    public String stringOf(Environment environment) {
        return "Impostato il colore di riempimento dell'area chiusa in"
                + environment.getCursor().getAreaColor().getRed() + " "
                + environment.getCursor().getAreaColor().getGreen() + " "
                + environment.getCursor().getAreaColor().getBlue();
    }
}