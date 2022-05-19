package it.unicam.cs.pa.logo;

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

    public void increaseDirection(int num) {
        direction = (direction + num) % 360;
    }

    public void decreaseDirection(int num) {
        increaseDirection(-num);
    }

    @Override
    public Direction defaultDirection() {
        return new TwoDimDirection();
    }
}
