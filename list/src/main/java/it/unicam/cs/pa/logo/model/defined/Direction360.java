package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Direction;

/**
 * Rappresenta una direzione in un piano a due dimensioni
 */
public class Direction360 implements Direction<Integer> {
    private int angle;

    public Direction360(int direction) {
        this.angle = direction % 360;
    }

    public Direction360() {
        this.angle = 0;
    }

    @Override
    public final Integer getValue() {
        return angle;
    }

    @Override
    public void increase(double num) {
        angle = (int) (angle + num) % 360;
    }
}
