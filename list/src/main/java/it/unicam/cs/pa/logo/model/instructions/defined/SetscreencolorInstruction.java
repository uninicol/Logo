package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione SETSCREENCOLOR, imposta il colore di background dell’area di disegno
 */
public final class SetscreencolorInstruction extends Instruction {
    public SetscreencolorInstruction() {
        super(3);
    }

    @Override
    public Environment apply(Environment environment, Queue<String> script) {
        int red = getAttribute(script);
        int green = getAttribute(script);
        int blue = getAttribute(script);
        environment.setBackgroundColor(red, green, blue);
        return environment;
    }

    @Override
    public String stringOf(Environment environment) {
        Color color = environment.getBackgroundColor();
        return String.format("impostato il colore di background in r:%d g:%d b:%d",
                color.getRed(),
                color.getGreen(),
                color.getBlue());
    }
}
