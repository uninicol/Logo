package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Questa classe descrive la modalitò di esecuzione passo passo
 */
public class StepByStepExecution<I extends Instruction<E>, E extends Environment<?>> {

    public void execute(Controller<I, E> controller, BufferedReader br) throws IOException {
        System.out.println("Hai scelto l'esecuzione passo passo, separare ogni parola da uno spazio\nScrivere EXIT per terminare");
        while (true) {
            String command = br.readLine().toUpperCase();
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
