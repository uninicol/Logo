package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.LinearSegment;
import it.unicam.cs.pa.logo.TwoDimCoordinate;
import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.*;

public final class BackwardInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public BackwardInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void execute(Deque<String> instruction) {
        int distance = -getAttribute(instruction);
        //determino il punto di arrivo con dovuti limiti
        TwoDimCoordinate endPoint = (TwoDimCoordinate) getEnvironment().getCursor().getPosition()
                .getCoordinateFromDistance(distance, getEnvironment().getCursor());
        if (getEnvironment().getCursor().isPlot())
            //inserisce il tratto nell'environment
            getEnvironment().drawLine(new LinearSegment(getEnvironment().getCursor().getPosition(), endPoint));
        //altrimenti si sposta solo
        getEnvironment().getCursor().setPosition(endPoint);
    }
}
