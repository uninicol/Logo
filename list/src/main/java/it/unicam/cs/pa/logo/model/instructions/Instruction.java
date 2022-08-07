package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionWriter;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;

import java.util.Objects;
import java.util.Queue;

/**
 * Classe astratta che rappresenta un'istruzione
 */
public abstract class Instruction<E extends Environment<?>> implements InstructionWriter<E> {

    /**
     * Esegue uno script d'istruzioni LOGO
     */
    public static final Executor<Instruction<SimpleEnvironment>, SimpleEnvironment> LOGO_EXECUTOR = (registry, environment, script) -> {
        while (!script.isEmpty()) {
            registry.parse(script.poll(), environment)
                    .ifPresent(instruction -> instruction.apply(script));
        }
        return environment;
    };

    private final E environment;
    private final int numOfAttributes;
    private int requestedAttributes = 0;

    public Instruction(E environment, int numOfAttributes) {
        this.environment = environment;
        this.numOfAttributes = numOfAttributes;
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