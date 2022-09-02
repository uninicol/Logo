package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione SETPENCOLOR, imposta il colore della penna
 */
public final class SetpencolorInstruction implements Instruction<SimpleEnvironment> {

    @Override
    public String stringOf(SimpleEnvironment environment) {
        Color color = environment.getCursor().getLineColor();
        return String.format("impostato il colore della penna in r:%d g:%d b:%d",
                color.getRed(),
                color.getGreen(),
                color.getBlue());
    }

    @Override
    public SimpleEnvironment apply(SimpleEnvironment environment, Queue<String> script) {
        int red = getIntegerAttribute(script);
        int green = getIntegerAttribute(script);
        int blue = getIntegerAttribute(script);
        environment.getCursor().setLineColor(
                new Color(
                        red, green, blue
                )
        );
        return environment;
    }
}
