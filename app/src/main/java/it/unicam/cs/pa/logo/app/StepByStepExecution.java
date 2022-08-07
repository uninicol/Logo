package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.io.IOException;

import static it.unicam.cs.pa.logo.app.App.br;

/**
 * Questa classe descrive la modalitò di esecuzione passo passo
 */
public class StepByStepExecution implements Execution<Instruction<SimpleEnvironment>, SimpleEnvironment> {

    @Override
    public void execute(Controller<Instruction<SimpleEnvironment>, SimpleEnvironment> controller) throws IOException {
        System.out.println("Hai scelto l'esecuzione passo passo, separare ogni parola da uno spazio\nScrivere EXIT per terminare");
        while (true) {
            String command = br.readLine();
            if (command.equalsIgnoreCase("EXIT")) break;
            controller.computeScript(command);
        }
        System.out.println("Computazione conclusa");
    }
}
