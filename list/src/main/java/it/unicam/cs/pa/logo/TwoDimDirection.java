package it.unicam.cs.pa.logo;

/**
 * Rappresenta una direzione in un piano a due dimensioni
 */
public class TwoDimDirection implements Direction {
    private int direction;

    public TwoDimDirection(int direction) {
        this.direction = direction % 360;
    }

    public TwoDimDirection() {
        this.direction = 0;
    }

    public int getDirection() {
        return direction;
    }

    /**
     * Gira la direzione in senso orario
     * @param num i gradi da girare
     */
    public void increaseDirection(int num) {
        direction = (direction + num) % 360;
    }

    /**
     * Gira la direzione in senso antiorario
     * @param num i gradi da girare
     */
    public void decreaseDirection(int num) {
        increaseDirection(-num);
    }

    /**
     * Restituisce la direzione di default
     * @return la direzione di default
     */
    @Override
    public Direction defaultDirection() {
        return new TwoDimDirection();
    }
}
