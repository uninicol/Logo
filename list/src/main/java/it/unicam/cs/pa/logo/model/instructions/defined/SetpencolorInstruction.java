package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione SETPENCOLOR, imposta il colore della penna
 */
public final class SetpencolorInstruction extends Instruction<SimpleEnvironment> {
    public SetpencolorInstruction(SimpleEnvironment environment) {
        super(environment, 3);
    }

    @Override
    public SimpleEnvironment apply(Queue<String> script) {
        int red = getAttribute(script);
        int green = getAttribute(script);
        int blue = getAttribute(script);
        getEnvironment().getCursor().setLineColor(
                new Color(
                        red, green, blue
                )
        );
        return getEnvironment();
    }

    @Override
    public String stringOf(SimpleEnvironment environment) {
        Color color = environment.getCursor().getLineColor();
        return String.format("impostato il colore della penna in r:%d g:%d b:%d",
                color.getRed(),
                color.getGreen(),
                color.getBlue());
    }
}
