package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        new App().run();
    }

    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("--------------LOGO--------------");
        System.out.println("prima di iniziare inserire lunghezza e altezza della tavola da disegno");
        Controller controller = getController(scanner);
        printBoard();
        switch (scanner.next()) {
            case "1" -> new StepByStepExecution().execute(controller, scanner);
            case "2" -> new FileExecution().execute(controller, scanner);
        }
        System.out.println("Salvare su file l'esecuzione? S/n");
        if (scanner.next().equals("S")) {
            File file = new File("output.logo");
            controller.save(file);
            System.out.println("File salvato su " + file.toPath());
        }
        scanner.close();
    }


    private void printBoard() {
        System.out.println("Scegli:");
        System.out.println("1) esegui il comando passo passo");
        System.out.println("2) esegui un programma logo su un file");
    }

    Controller getController(Scanner scanner) {
        //TODO: scanner.nextInt() eseguito con gradle run non prende nulla e lancia eccezione, per ora faccio environment fisso grande 1000x1000
//        System.out.print("Lunghezza:");
//        int lunghezza = scanner.nextInt();
//        System.out.println("\n\n##" + lunghezza + "##\n\n");
//        System.out.print("Altezza:");
//        int altezza = scanner.nextInt();
        return Controller.getTwoDimController(1000, 1000);
    }
}