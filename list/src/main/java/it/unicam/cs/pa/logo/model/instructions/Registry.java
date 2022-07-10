package it.unicam.cs.pa.logo.model.instructions;

import java.util.function.Function;

/**
 * Questa classe è usata per creare e restituire oggetti di tipo Instruction
 *
 * @param <I>
 */
public interface Registry<I extends Instruction<?>> {

    /**
     * Crea una nuova funzione di creazione di un'istruzione
     *
     * @param name il nome del comando
     * @return la funzione di creazione di un'istruzione
     */
    Function<String, I> createInstruction(String name);

    /**
     * Restituisce la funzione che crea l'istruzione
     *
     * @param name il nome dell'istruzione
     * @return la funzione di creazione di un'istruzione
     */
    Function<String, I> get(String name);

    /**
     * Restituisce l'istruzione associato al nome
     *
     * @param name il nome dell'istruzione
     * @return l'istruzione
     */
    default I getInstruction(String name) {
        return get(name).apply(name);
    }
}
