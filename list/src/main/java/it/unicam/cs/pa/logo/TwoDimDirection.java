package it.unicam.cs.pa.logo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

    public int getAngle() {
        return angle;
    }

    /**
     * Gira la direzione in senso orario
     * @param num i gradi da girare
     */
    public void increaseDirection(int num) {
        angle = (angle + num) % 360;
    }

    /**
     * Gira la direzione in senso antiorario
     * @param num i gradi da girare
     */
    public void decreaseDirection(int num) {
        increaseDirection(-num);
    }

    @Override
    public Direction getDirection() {
        return new TwoDimDirection(this.angle);
    }

    /**
     * Restituisce la direzione di default
     * @return la direzione di default
     */
    @Override
    public Direction defaultDirection() {
        return new TwoDimDirection();
    }

    @Override
    public List<Integer> getDirectionValues() {
        return List.of(angle);
    }
}
