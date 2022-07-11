package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Cursor;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione SETSCREENCOLOR, imposta il colore di background dell’area di disegno
 */
public final class SetscreencolorInstruction extends Instruction<Environment<Cursor>> {
    public SetscreencolorInstruction(Environment<Cursor> environment) {
        super(environment, 3);
    }

    @Override
    public Environment<Cursor> apply(Queue<String> script) {
        int red = getAttribute(script);
        int green = getAttribute(script);
        int blue = getAttribute(script);
        getEnvironment().setBackgroundColor(new Color(red, green, blue));
        return getEnvironment();
    }

    @Override
    public String stringOf(Environment<Cursor> environment) {
        Color color = environment.getBackgroundColor();
        return String.format("impostato il colore di background in r:%d g:%d b:%d",
                color.getRed(),
                color.getGreen(),
                color.getBlue());
    }
}
