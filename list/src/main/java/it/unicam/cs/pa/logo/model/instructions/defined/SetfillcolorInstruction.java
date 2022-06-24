package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione SETFILLCOLOR, imposta il colore del riempimento di un’area chiusa
 */
public final class SetfillcolorInstruction extends Instruction {

    public SetfillcolorInstruction() {
        super(3);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) {
        int red = getAttribute(script);
        int green = getAttribute(script);
        int blue = getAttribute(script);
        Color color = new Color(red, green, blue);
        environment.getCursor().setAreaColor(color);
        return environment;
    }

    @Override
    public String stringOf(Environment environment) {
        Color color = environment.getCursor().getAreaColor();
        return String.format("impostato il colore di riempimento dell'area chiusa in r:%d g:%d b:%d",
                color.getRed(),
                color.getGreen(),
                color.getBlue());
    }
}
