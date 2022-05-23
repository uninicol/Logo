package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.LinearSegment;
import it.unicam.cs.pa.logo.TwoDimCoordinate;
import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.Deque;

public final class BackwardInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public BackwardInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void accept(Deque<String> instruction) {
        int distance = -getAttribute(instruction);
        //determino il punto di arrivo con dovuti limiti
        TwoDimCoordinate endPoint = getEnvironment()
                .getCursor()
                .getCoordinateFromDistance(distance);
        if (getEnvironment().getCursor().isPlot())  //disegna sul piano
            getEnvironment().drawLine(new LinearSegment(getEnvironment().getCursor().getPosition(), endPoint));
        else //non disegna sul piano
            getEnvironment().getCursor().setPosition(endPoint);
        getEnvironment().getCursor().setPosition(endPoint);
    }
}
