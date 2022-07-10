package it.unicam.cs.pa.logo;

import it.unicam.cs.pa.logo.io.EnvironmentWriter;
import it.unicam.cs.pa.logo.io.InstructionLoader;
import it.unicam.cs.pa.logo.io.InstructionReader;
import it.unicam.cs.pa.logo.io.TwoDimEnvWriter;
import it.unicam.cs.pa.logo.model.defined.Cursor;
import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.defined.Environment;
import it.unicam.cs.pa.logo.model.instructions.Executor;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Questa classe è usata per controllare le attività di un'esecuzione LOGO
 */
public class Controller<I extends Instruction<E>, E extends Environment> {

    private final EnvironmentWriter writer;
    private final InstructionReader<I, E> registry;
    private final Executor<I, E> executor;
    private final E currentField;

    /**
     * Crea un controller che userà uno scrittore per esportare un ambiente, l'ambiente su cui avverrà la computazione,
     * un registro contenente il set d'istruzioni che possono essere eseguiti
     *
     * @param writer      lo scrittore
     * @param environment l'environment
     * @param registry    il registro
     * @param executor    l'esecutore
     */
    public Controller(EnvironmentWriter writer, E environment,
                      InstructionReader<I, E> registry, Executor<I, E> executor) {
        this.writer = writer;
        this.currentField = environment;
        this.registry = registry;
        this.executor = executor;
    }

    /**
     * Restituisce un controller di un environment bidimensionale
     *
     * @param length la lunghezza dell'environment
     * @param height l'altezza dell'environment
     * @return un controller di un environment bidimensionale
     */
    public static Controller<Instruction<Environment>, Environment> getTwoDimController(int length, int height) {
        return new Controller<>(new TwoDimEnvWriter(),
                new Environment(length, height, new Cursor(new Point(length / 2, height / 2), new Direction360())),
                InstructionLoader.DEFAULT_LOGO_READER, Instruction.EXECUTOR);
    }

    /**
     * Scrive l'environment su un dato file
     *
     * @param file dove verrà salvato l'environment
     * @throws IOException se avviene un errore IO
     */
    public void save(File file) throws IOException {
        writer.writeTo(file, this.currentField);
    }

    /**
     * Legge un file contenente uno script LOGO
     *
     * @param file il file contenente lo script
     * @return lo script
     * @throws IOException se avviene un errore IO
     */
    public List<String> read(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    /**
     * Computa uno script
     *
     * @param script lo script da eseguire
     */
    public void computeScript(String script) throws IOException {
        Queue<String> scriptCommands = Arrays.stream(script.split(" "))
                .collect(Collectors.toCollection(LinkedList::new));
        executor.execute(registry, currentField, scriptCommands);
    }
}
