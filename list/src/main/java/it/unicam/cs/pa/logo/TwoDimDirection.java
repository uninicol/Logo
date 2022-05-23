package it.unicam.cs.pa.logo;

import java.util.List;

/**
 * Rappresenta una direzione in un piano a due dimensioni
 */
public class TwoDimDirection implements Direction {
    private int angle = 0;

    public TwoDimDirection(int direction) {
        this.angle = direction % 360;
    }

    public TwoDimDirection() {
    }

    public int getAngle() {
        return angle;
    }

    /**
     * Gira la direzione in senso orario
     *
     * @param num i gradi da girare
     */
    public void increaseDirection(int num) {
        angle = (angle + num) % 360;
    }

    /**
     * Gira la direzione in senso antiorario
     *
     * @param num i gradi da girare
     */
    public void decreaseDirection(int num) {
        angle = (angle - num) % 360;
    }

    @Override
    public Direction getDirection() {
        return new TwoDimDirection(this.angle);
    }

    @Override
    public Direction defaultDirection() {
        return new TwoDimDirection();
    }

    @Override
    public List<Integer> getDirectionValues() {
        return List.of(angle);
    }
}
