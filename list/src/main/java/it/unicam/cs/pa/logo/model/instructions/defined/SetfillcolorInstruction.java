package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione SETFILLCOLOR, imposta il colore del riempimento di un’area chiusa
 */
public final class SetfillcolorInstruction implements Instruction<SimpleEnvironment> {

    @Override
    public String stringOf(SimpleEnvironment environment) {
        Color color = environment.getCursor().getAreaColor();
        return String.format("impostato il colore di riempimento dell'area chiusa in r:%d g:%d b:%d",
                color.getRed(),
                color.getGreen(),
                color.getBlue());
    }

    @Override
    public SimpleEnvironment apply(SimpleEnvironment environment, Queue<String> script) {
        int red = getIntegerAttribute(script);
        int green = getIntegerAttribute(script);
        int blue = getIntegerAttribute(script);
        Color color = new Color(red, green, blue);
        environment.getCursor().setAreaColor(color);
        return environment;
    }
}
