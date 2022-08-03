package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Environment;

public class SimpleEnvironment extends Environment<SimpleCursor> {
    public SimpleEnvironment(int width, int height, SimpleCursor cursor) {
        super(width, height, cursor);
    }
}
