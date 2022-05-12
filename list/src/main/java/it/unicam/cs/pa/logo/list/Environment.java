package it.unicam.cs.pa.logo.list;

import java.util.List;

/**
 * Rappresenta uno spazio secondo delle coordinate
 *
 * @param <C> le coordinate
 */
public abstract class Environment<C extends Coordinates> {
    List<Shape<C>> shapes;

    public Environment(List<Shape<C>> shapes) {
        this.shapes = shapes;
    }

    public List<Shape<C>> getShapes() {
        return shapes;
    }
}