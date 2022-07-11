package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;
import it.unicam.cs.pa.logo.model.Cursor;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Scanner;

/**
 * Interfaccia funzionale che descrive una modalità di esecuzione di un programma LOGO
 */
@FunctionalInterface
public interface Execution<I extends Instruction<E>, E extends Environment<Cursor>> {

    /**
     * Esegue una computazione di un programma LOGO
     *
     * @param controller il controller
     * @param scanner    lo scanner per leggere i dati
     */
    void execute(Controller<I, E> controller, Scanner scanner);
}
