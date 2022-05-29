package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.Shape;
import it.unicam.cs.pa.logo.TwoDimCoordinate;
import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.awt.*;
import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione SETFILLCOLOR
 */
public final class SetfillcolorInstruction extends AbstractInstruction<TwoDimEnvironment> {

    public SetfillcolorInstruction(TwoDimEnvironment environment) {
        super(3, environment);
    }

    @Override
    public void accept(LinkedList<String> instruction) {
        Shape<TwoDimCoordinate> lastShape = getEnvironment().getShapes().get(getEnvironment().getShapes().size() - 1);
        if (!lastShape.isClosed())
            throw new IllegalArgumentException("Impossibile colorare area non chiusa");
        lastShape.setBackgroundColor(new Color(getAttribute(instruction), getAttribute(instruction), getAttribute(instruction)));
    }
}
