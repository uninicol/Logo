package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;

import java.io.IOException;
import java.util.Scanner;

/**
 * Questa classe descrive la modalitò di esecuzione passo passo
 */
public class StepByStepExecution {

    public void execute(Controller controller, Scanner scanner) {
        System.out.println("Hai scelto l'esecuzione passo passo, separare ogni parola da uno spazio\nScrivere EXIT per terminare");
        while (true) {
            String command = scanner.next();
            if (command.equalsIgnoreCase("EXIT")) break;
            try {
                controller.computeScript(command);
            } catch (IOException e) {
                System.out.println("Impossibile eseguire il comando " + command);
            }
        }
        System.out.println("Computazione conclusa");
    }
}
