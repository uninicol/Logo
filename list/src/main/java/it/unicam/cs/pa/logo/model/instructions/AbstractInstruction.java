package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionWriter;
import it.unicam.cs.pa.logo.model.Environment;

/**
 * Classe astratta che contiene gli attributi di un istruzione
 */
public abstract class AbstractInstruction implements Instruction, InstructionWriter {

    private final int numOfAttributes;
    private int requestedAttributes;

    public AbstractInstruction(int numOfAttributes) {
        this.numOfAttributes = numOfAttributes;
        this.requestedAttributes = 0;
    }

    @Override
    public final int getRequiredAttributesNumber() {
        return numOfAttributes;
    }

    @Override
    public final int getRequestedAttributesNumber() {
        return requestedAttributes;
    }

    @Override
    public final void setRequestedAttributesNumber(int number) {
        this.requestedAttributes = number;
    }
}