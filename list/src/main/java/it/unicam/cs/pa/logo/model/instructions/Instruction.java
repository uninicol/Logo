package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionWriter;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * Classe astratta che rappresenta un'istruzione
 */
public abstract class Instruction<E extends Environment<?>> implements InstructionWriter<E> {

    /**
     * Esegue uno script di istruzioni LOGO
     */
    public static final Executor<Instruction<SimpleEnvironment>, SimpleEnvironment> LOGO_EXECUTOR = (registry, environment, script) -> {
        Queue<String> scriptCopy = new LinkedList<>(script); //creo un clone altrimenti ho ConcurrentModificationException nello stream
        Stream.concat(
                        script.stream().takeWhile(str -> !str.equals("[")),//elimino lo script all'interno delle parentesi
                        script.stream().dropWhile(str -> !str.equals("]")) //problemi con inner loop
                )
                .map(str -> registry.parse(str, environment))
                .filter(Optional::isPresent)
                .forEach(instruction -> {
                    scriptCopy.poll();
                    instruction.get().apply(scriptCopy);
                });
        return environment;
    };

    private final E environment;
    private final int numOfAttributes;
    private int requestedAttributes;

    public Instruction(E environment, int numOfAttributes) {
        this.environment = environment;
        this.numOfAttributes = numOfAttributes;
        this.requestedAttributes = 0;
    }

    /**
     * Restituisce il risultato dell'applicazione dell'istruzione all'environment.
     *
     * @param script lo script contenente il comando
     * @return l'environment modificato dall'esecuzione
     */
    public abstract E apply(Queue<String> script);

    /**
     * Restituisce il numero di attributi che l'istruzione ha bisogno
     *
     * @return il numero di attributi che l'istruzione ha bisogno
     */
    public final int getRequiredAttributesNumber() {
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

    protected final E getEnvironment() {
        return environment;
    }

    protected final int getAttribute(Queue<String> script) {
        if (getRequiredAttributesNumber() == getRequestedAttributesNumber())
            throw new RuntimeException("richiesti troppi attributi");
        setRequestedAttributesNumber(getRequestedAttributesNumber() + 1);
        return Integer.parseInt(Objects.requireNonNull(script.poll()));
    }
}