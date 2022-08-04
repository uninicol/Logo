package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Environment;

public class SimpleEnvironment extends Environment<SimpleCursor> {


    public SimpleEnvironment(int width, int height, SimpleCursor cursor) {
        super(width, height, cursor);
    }

    @Override
    public boolean contains(int x, int y) {
        return x >= 0 &&
                x <= width &&
                y >= 0 &&
                y <= height;
    }
}
