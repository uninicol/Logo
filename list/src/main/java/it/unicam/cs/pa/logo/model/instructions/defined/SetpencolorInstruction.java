package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione SETPENCOLOR, imposta il colore della penna
 */
public final class SetpencolorInstruction extends Instruction {
    public SetpencolorInstruction() {
        super(3);
    }

    @Override
    public Environment apply(Environment environment, Queue<String> script) {
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
        Color color = environment.getCursor().getLineColor();
        return String.format("impostato il colore della penna in r:%d g:%d b:%d",
                color.getRed(),
                color.getGreen(),
                color.getBlue());
    }
}
