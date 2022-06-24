package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionWriter;
import it.unicam.cs.pa.logo.model.Environment;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Classe astratta che rappresenta un'istruzione
 */
public abstract class Instruction implements InstructionWriter {

    public static final Executor<Instruction> EXECUTOR = (registry, environment, script) -> {
        while (!script.isEmpty()) {
            String command = script.poll();
            if (command.equals("]")) break;
            Instruction instruction = registry.getInstruction(command);
            if (instruction == null) throw new IOException();
            environment = instruction.apply(environment, script);
            System.out.println(command + " ha " + registry.getInstruction(command).stringOf(environment));
        }
        return environment;
    };

    private final int numOfAttributes;
    private int requestedAttributes;

    public Instruction(int numOfAttributes) {
        this.numOfAttributes = numOfAttributes;
        this.requestedAttributes = 0;
    }

    /**
     * Restituisce il risultato dell'applicazione dell'istruzione all'environment.
     *
     * @param environment l'environment
     * @param script      lo script contenente il comando
     * @return l'environment modificato dall'esecuzione
     */
    public abstract Environment apply(Environment environment, LinkedList<String> script) throws IOException;

    /**
     * Restituisce il numero di attributi che l'istruzione ha bisogno
     *
     * @return il numero di attributi che l'istruzione ha bisogno
     */
    protected final int getRequiredAttributesNumber() {
        return numOfAttributes;
    }

    /**
     * Restituisce il numero di attributi che l'istruzione ha richiesto
     *
     * @return il numero di attributi che l'istruzione ha richiesto
     */
    protected final int getRequestedAttributesNumber() {
        return requestedAttributes;
    }

    /**
     * Imposta il numero di attributi che l'istruzione ha richiesto
     */
    protected final void setRequestedAttributesNumber(int number) {
        this.requestedAttributes = number;
    }

    protected final int getAttribute(LinkedList<String> script) {
        if (getRequiredAttributesNumber() == getRequestedAttributesNumber())
            throw new RuntimeException("richiesti troppi attributi");
        setRequestedAttributesNumber(getRequestedAttributesNumber() + 1);
        return Integer.parseInt(Objects.requireNonNull(script.poll()));
    }
}