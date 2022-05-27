package it.unicam.cs.pa.logo.instructions.defined;

import it.unicam.cs.pa.logo.DrawerClass;
import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.AbstractInstruction;

import java.util.Deque;

public final class ForwardInstruction extends AbstractInstruction<TwoDimEnvironment> {

    public ForwardInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void accept(Deque<String> instruction) {
        int distance = getAttribute(instruction);
        //determino il punto di arrivo con dovuti limiti
        DrawerClass drawer = new DrawerClass(getEnvironment());
        drawer.drawLine(distance);
    }
}