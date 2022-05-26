package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.Coordinate;
import it.unicam.cs.pa.logo.Direction;
import it.unicam.cs.pa.logo.Environment;

import java.util.Objects;

/**
 * Classe astratta che contiene gli attributi di un istruzione
 *
 * @param <E> l'ambiente su cui l'istruzione opera
 */
public abstract class AbstractInstruction<E extends Environment<? extends Coordinate, ? extends Direction>>
        implements Instruction<E> {
    private final int numAttributes;
    private final E environment;

    public AbstractInstruction(int numAttributes, E environment) {
        this.numAttributes = numAttributes;
        this.environment = Objects.requireNonNull(environment);
    }

    @Override
    public int getRequiredAttributesNumber() {
        return numAttributes;
    }

    @Override
    public E getEnvironment() {
        return environment;
    }
}