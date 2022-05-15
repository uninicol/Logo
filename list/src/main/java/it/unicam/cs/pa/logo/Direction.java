package it.unicam.cs.pa.logo;

public record Direction(int direction) {
    public Direction {
        if (direction < 0 || direction > 360) throw new IllegalArgumentException();
    }
}
