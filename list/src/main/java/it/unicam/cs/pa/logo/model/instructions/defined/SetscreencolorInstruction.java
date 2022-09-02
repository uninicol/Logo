package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione SETSCREENCOLOR, imposta il colore di background dell’area di disegno
 */
public final class SetscreencolorInstruction implements Instruction<SimpleEnvironment> {
    
    @Override
    public String stringOf(SimpleEnvironment environment) {
        Color color = environment.getBackgroundColor();
        return String.format("impostato il colore di background in r:%d g:%d b:%d",
                color.getRed(),
                color.getGreen(),
                color.getBlue());
    }

    @Override
    public SimpleEnvironment apply(SimpleEnvironment environment, Queue<String> script) {
        int red = getIntegerAttribute(script);
        int green = getIntegerAttribute(script);
        int blue = getIntegerAttribute(script);
        environment.setBackgroundColor(new Color(red, green, blue));
        return environment;
    }
}
