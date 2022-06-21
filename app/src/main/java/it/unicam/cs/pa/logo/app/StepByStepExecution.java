package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;

import java.io.IOException;
import java.util.Scanner;

public class StepByStepExecution {

    public void execute(Scanner scanner) {
        System.out.println("Hai scelto l'esecuzione passo passo, separare ogni parola da uno spazio\nScrivere EXIT per terminare");
        System.out.println("prima di iniziare inserire lunghezza e altezza della tavola da disegno");
        Controller controller = App.getController(scanner);
        String command;
        do {
            command = scanner.nextLine();
            try {
                controller.computeScript(command);
            } catch (IOException e) {
                System.out.println("Impossibile eseguire il comando " + command);
            }
        } while (command.toUpperCase().equals("EXIT"));
        System.out.println("Computazione conclusa");
    }
}
