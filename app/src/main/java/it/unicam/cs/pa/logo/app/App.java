package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App app = new App();
        Scanner scanner = new Scanner(System.in);
        String continueExec;
        do {
            app.printBoard();
            int scelta = scanner.nextInt();
            switch (scelta) {
                case 1 -> new StepByStepExecution().execute(scanner);
                case 2 -> new FileExecution().execute(scanner);
            }
            System.out.println("Continuare? s/N");
            continueExec = scanner.nextLine();
        } while (!continueExec.toUpperCase().equals("S"));
        scanner.close();
    }

    private void printBoard() {
        System.out.println("--------------LOGO--------------");
        System.out.println("Scegli:");
        System.out.println("1) esegui il comando passo passo");
        System.out.println("2) esegui un programma logo su un file");
    }

    static Controller getController(Scanner scanner) {
        System.out.print("Lunghezza:");
        int lunghezza = scanner.nextInt();
        System.out.print("Altezza:");
        int altezza = scanner.nextInt();
        return Controller.getTwoDimController(lunghezza, altezza);
    }
}