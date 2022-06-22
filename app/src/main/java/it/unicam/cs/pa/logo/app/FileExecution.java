package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Questa classe descrive la modalitò di esecuzione tramite file
 */
public class FileExecution {

    public void execute(Controller controller, Scanner scanner) throws IOException {
        System.out.println("Hai scelto l'esecuzione da un file\nLo script deve essere scritto in un'unica riga\nInserire nome del file (deve essere nella stessa cartella del programma)");
        List<String> script = controller.read(new File(scanner.next()));
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
