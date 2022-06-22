package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;

import java.util.Scanner;

/**
 * Interfaccia funzionale che descrive una modalità di esecuzione di un programma LOGO
 */
@FunctionalInterface
public interface Execution {

    /**
     * Esegue una computazione di un programma LOGO
     *
     * @param controller il controller
     * @param scanner    lo scanner per leggere i dati
     */
    void execute(Controller controller, Scanner scanner);
}
