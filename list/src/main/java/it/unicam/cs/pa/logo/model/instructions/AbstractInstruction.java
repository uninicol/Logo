package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.model.Coordinate;
import it.unicam.cs.pa.logo.model.Direction;
import it.unicam.cs.pa.logo.model.Environment;

import java.util.Objects;

/**
 * Classe astratta che contiene gli attributi di un istruzione
 *
 * @param <E> l'ambiente su cui l'istruzione opera
 */
public abstract class AbstractInstruction<E extends Environment<? extends Coordinate<?>, ? extends Direction<?>>>
        implements Instruction<E> {
    private final E environment;
    private final int numAttributes;
    private int countRequestedAttributes = 0;


    @Override
    public int getCountRequestedAttributes() {
        return countRequestedAttributes;
    }

    @Override
    public void setCountRequestedAttributes(int number) {
        this.countRequestedAttributes = number;
    }

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