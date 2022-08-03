package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            new App().run(args, br);
        }
    }

    public void run(String[] args, BufferedReader br) throws IOException {
        System.out.println("--------------LOGO--------------");
        Controller<Instruction<Environment<?>>, Environment<?>> controller = getController(br, args);
        printBoard();
        switch (Integer.parseInt(br.readLine())) {
            case 1 -> new StepByStepExecution<>().execute(controller, br);
            case 2 -> new FileExecution<>().execute(controller, br);
            default -> throw new IOException("Input errato");
        }
        System.out.println("Salvare su file l'esecuzione? S/n");
        if (br.readLine().equals("S")) {
            File file = new File("output.logo");
            controller.save(file);
            System.out.println("File salvato su " + file.toPath());
        }
    }


    private void printBoard() {
        System.out.println("Scegli:");
        System.out.println("1) esegui il comando passo passo");
        System.out.println("2) esegui un programma logo su un file");
    }

    Controller<Instruction<Environment<?>>, Environment<?>> getController(BufferedReader br, String[] args) throws IOException {
        if (args.length == 2) {
            int lunghezza = Integer.parseInt(args[0]), altezza = Integer.parseInt(args[1]);
            System.out.printf("Useremo una tavola da disegno di lunghezza %d e altezza %d%n", lunghezza, altezza);
            return Controller.getTwoDimController(lunghezza, altezza);
        }
        if (args.length == 0)
            System.out.println("prima di iniziare inserire lunghezza e altezza della tavola da disegno");
        if (args.length == 1)
            System.out.println("Parametri insufficienti! Inseriamoli da capo");
        System.out.print("Lunghezza:");
        int lunghezza = Integer.parseInt(br.readLine());
        System.out.print("Altezza:");
        int altezza = Integer.parseInt(br.readLine());
        return Controller.getTwoDimController(lunghezza, altezza);
    }
}