package it.unicam.cs.pa.logo;

import it.unicam.cs.pa.logo.io.EnvironmentWriter;
import it.unicam.cs.pa.logo.io.TwoDimEnvWriter;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import it.unicam.cs.pa.logo.model.instructions.Executor;
import it.unicam.cs.pa.logo.model.instructions.InstructionRegistry;
import it.unicam.cs.pa.logo.model.instructions.Registry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

/**
 * Questa classe è usata per controllare le attività intorno a un'esecuzione LOGO
 */
public class Controller {

    private final EnvironmentWriter writer;
    private final Registry<Instruction> registry;
    private final Executor<Instruction> executor = Instruction.EXECUTOR;
    private final Environment currentField;

    /**
     * Crea un controller che userà uno scrittore per esportare un ambiente, l'ambiente su cui avverrà la computazione,
     * un registro contenente il set d'istruzioni che possono essere eseguiti
     *
     * @param writer      lo scrittore
     * @param environment l'environment
     * @param registry    il registro
     */
    public Controller(EnvironmentWriter writer, Environment environment, Registry<Instruction> registry) {
        this.writer = writer;
        this.currentField = environment;
        this.registry = registry;
    }

    public static Controller getTwoDimController(int length, int height) {
        return new Controller(new TwoDimEnvWriter(),
                new TwoDimEnvironment(length, height),
                InstructionRegistry.getTwoDimRegistrySet());
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
        LinkedList<String> scriptCommands = new LinkedList<>(List.of(script.split(" ")));
        executor.execute(registry, currentField, scriptCommands);
    }
}
