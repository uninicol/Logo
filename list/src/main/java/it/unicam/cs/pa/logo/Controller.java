package it.unicam.cs.pa.logo;

import it.unicam.cs.pa.logo.io.EnvironmentWriter;
import it.unicam.cs.pa.logo.io.TwoDimEnvWriter;
import it.unicam.cs.pa.logo.io.TwoDimInstructionLoader;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;
import it.unicam.cs.pa.logo.model.instructions.Executor;
import it.unicam.cs.pa.logo.model.instructions.InstructionRegistry;
import it.unicam.cs.pa.logo.model.instructions.Registry;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is used to control the activities around a GOL execution.
 */
public class Controller {

    private final EnvironmentWriter writer;
    private final Registry<AbstractInstruction> registry;
    private final Executor<AbstractInstruction> executor = AbstractInstruction.EXECUTOR;

    private final Environment currentField;

    //private LinkedList<Environment<S, C>> history;

    public static Controller getTwoDimController(int length, int height) {
        return new Controller(new TwoDimEnvWriter(),
                new TwoDimEnvironment(length, height),
                new InstructionRegistry(TwoDimInstructionLoader.READER));
    }

    /**
     * Creates a new controller that will used the given writer, to save and export fields, loader, to read
     * schemata from files, and rules to compute execution.
     *
     * @param writer      writer used to save fields on files.
     * @param environment builder used to instantiate the environment.
     */
    public Controller(EnvironmentWriter writer, Environment environment, Registry<AbstractInstruction> registry) {
        this.writer = writer;
        this.currentField = environment;
        this.registry = registry;
    }

    /**
     * Writes the handled environment to the given file.
     *
     * @param file file on which we can save the environment.
     * @throws IOException if an I/O error occurs while writing the data.
     */
    public void save(File file) throws IOException {
        writer.writeTo(file, this.currentField);
    }

    public void clear() {
        this.currentField.clearAll();
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
