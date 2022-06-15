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

    /**
     * Gira la direzione in senso orario
     *
     * @param num i gradi da girare
     */
    public void increaseDirection(int num) {
        angle = (angle + num) % 360;
    }

    @Override
    public Integer getValue() {
        return angle;
    }
}
