package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.Direction;

/**
 * Rappresenta una direzione in un piano a due dimensioni
 */
public class TwoDimDirection implements Direction {
    private int angle;

    public TwoDimDirection(int direction) {
        this.angle = direction % 360;
    }

    public TwoDimDirection() {
        this.angle = 0;
    }

    @Override
    public final Integer getValue() {
        return angle;
    }

    @Override
    public void increase(int num) {
        angle = (angle + num) % 360;
    }
}
