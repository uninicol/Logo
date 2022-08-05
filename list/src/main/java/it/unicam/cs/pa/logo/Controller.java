package it.unicam.cs.pa.logo;

import it.unicam.cs.pa.logo.io.EnvironmentWriter;
import it.unicam.cs.pa.logo.io.InstructionLoader;
import it.unicam.cs.pa.logo.io.InstructionReader;
import it.unicam.cs.pa.logo.io.SimpleEnvWriter;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.defined.SimpleCursor;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Executor;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Questa classe è usata per controllare le attività di un'esecuzione LOGO
 */
public class Controller<I extends Instruction<E>, E extends Environment<?>> {

    private final EnvironmentWriter<E> writer;
    private final InstructionReader<I, E> registry;
    private final Executor<I, E> executor;
    private final E currentField;

    /**
     * Crea un controller che userà uno scrittore per esportare un ambiente, l'ambiente su cui avverrà la computazione,
     * e un set di istruzioni che possono essere eseguiti
     *
     * @param writer      lo scrittore
     * @param environment l'environment
     * @param registry    il set di istruzioni
     * @param executor    l'esecutore
     */
    public Controller(EnvironmentWriter<E> writer, E environment,
                      InstructionReader<I, E> registry, Executor<I, E> executor) {
        this.writer = writer;
        this.currentField = environment;
        this.registry = registry;
        this.executor = executor;
    }

    /**
     * Restituisce un controller di un environment generico
     *
     * @param length la lunghezza dell'environment
     * @param height l'altezza dell'environment
     * @return un controller di un environment generico
     */
    public static Controller<Instruction<SimpleEnvironment>, SimpleEnvironment> getTwoDimController(int length, int height) {
        return new Controller<>(
                new SimpleEnvWriter(),
                new SimpleEnvironment(
                        length,
                        height,
                        new SimpleCursor(new Point(length / 2, height / 2), new Direction360())
                ),
                InstructionLoader.DEFAULT_LOGO_READER,
                Instruction.LOGO_EXECUTOR);
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
    public void computeScript(String script) {
        script = script.toUpperCase();
        Queue<String> scriptCommands = new LinkedList<>(List.of(script.split("[\s\t\n]")));
        executor.execute(registry, currentField, scriptCommands);
    }
}
