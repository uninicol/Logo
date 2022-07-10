package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;
import it.unicam.cs.pa.logo.model.defined.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Questa classe descrive la modalitò di esecuzione tramite file
 */
public class FileExecution<I extends Instruction<E>, E extends Environment> {

    public void execute(Controller<I, E> controller, BufferedReader br) throws IOException {
        System.out.println("Hai scelto l'esecuzione da un file\nInserire nome del file (deve essere nella stessa cartella del programma)");
        List<String> script = controller.read(new File(br.readLine()));
        script.forEach((command) -> {
            try {
                controller.computeScript(command);
            } catch (IOException e) {
                System.out.println("Impossibile eseguire il comando");
            }
        });
        System.out.println("Computazione conclusa");
    }
}
