package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static it.unicam.cs.pa.logo.app.App.br;

/**
 * Questa classe descrive la modalitò di esecuzione tramite file
 */
public class FileExecution {

    public void execute(Controller<?, ?> controller) throws IOException {
        System.out.println("Hai scelto l'esecuzione da un file\nInserire nome del file (deve essere nella stessa cartella del programma)");
        List<String> script = controller.read(new File(br.readLine()));
        script.forEach(controller::computeScript);
        System.out.println("Computazione conclusa");
    }
}
