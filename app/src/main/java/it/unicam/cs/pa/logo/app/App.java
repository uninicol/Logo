package it.unicam.cs.pa.logo.app;

import it.unicam.cs.pa.logo.Controller;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class App {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Controller<Instruction<SimpleEnvironment>, SimpleEnvironment> controller;

    public static void main(String[] args) throws IOException {
        try {
            controller = getController(args);
            new App().run(controller);
        } finally {
            br.close();
        }
    }

    /**
     * Restituisce il controller definendo le dimensioni dell'environment
     *
     * @param args dimensioni dell'environment
     * @return il controller
     */
    private static Controller<Instruction<SimpleEnvironment>, SimpleEnvironment> getController(String[] args) {
        Optional<Pair<Integer, Integer>> envDimension = checkArgs(args);
        if (envDimension.isPresent())
            return Controller.getTwoDimController(envDimension.get().getLeft(), envDimension.get().getRight());
        int lunghezza = 0, altezza = 0;
        try {
            System.out.print("Lunghezza:");
            lunghezza = Integer.parseInt(br.readLine());
            System.out.print("Altezza:");
            altezza = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Controller.getTwoDimController(lunghezza, altezza);
    }

    /**
     * Verifica la correttezza degli argomenti dati per costruire l'environment
     *
     * @param args gli argomenti
     * @return le dimensioni dell'environent
     */
    private static Optional<Pair<Integer, Integer>> checkArgs(String[] args) {
        if (args.length == 0)
            System.out.println("prima di iniziare inserire lunghezza e altezza della tavola da disegno");
        if (args.length == 1)
            System.out.println("Parametri insufficienti! Inseriamoli da capo");
        if (args.length > 2)
            System.out.println("Numero parametri non corretto");
        if (args.length == 2) {
            int lunghezza = Integer.parseInt(args[0]), altezza = Integer.parseInt(args[1]);
            System.out.printf("Useremo una tavola da disegno di lunghezza %d e altezza %d%n", lunghezza, altezza);
            return Optional.of(Pair.of(lunghezza, altezza));
        }
        return Optional.empty();
    }

    public void run(Controller<Instruction<SimpleEnvironment>, SimpleEnvironment> controller) throws IOException {
        System.out.println("--------------LOGO--------------");
        printBoard();
        getStrategy().execute(controller);
        System.out.println("Salvare su file l'esecuzione? S/n");
        if (br.readLine().equalsIgnoreCase("S")) {
            File file = new File("output.logo");
            controller.save(file);
            System.out.println("File salvato su " + file.toPath());
        }
    }

    private void printBoard() {
        System.out.println("Scegli:");
        System.out.println("1) esegui il comando passo passo");
        System.out.println("2) esegui un programma logo da un file");
    }

    private Execution<Instruction<SimpleEnvironment>, SimpleEnvironment> getStrategy() throws IOException {
        return switch (Integer.parseInt(br.readLine())) {
            case 1 -> new StepByStepExecution();
            case 2 -> new FileExecution();
            default -> throw new IOException("Input errato");
        };
    }
}