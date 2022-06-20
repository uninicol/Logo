package it.unicam.cs.pa.logo;

import it.unicam.cs.pa.logo.io.EnvironmentWriter;
import it.unicam.cs.pa.logo.io.TwoDimEnvWriter;
import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimDirection;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;

import java.io.File;
import java.io.IOException;

/**
 * This class is used to control the activities around a GOL execution.
 */
public class Controller {

    private final EnvironmentWriter writer;
    //private final EnvironmentLoader<S, C> loader;

    //private final Supplier<Environment> environmentBuilder;

    //private final Rule<S> rules;

    private final Environment currentField;

    //private LinkedList<Environment<S, C>> history;

    public static Controller getTwoDimController(int length, int height) {
        return new Controller(new TwoDimEnvWriter(),
                //new ConwayFieldLoader<>(GridCoordinates.LOADER),
                new TwoDimEnvironment(length, height));
    }

    /**
     * Creates a new controller that will used the given writer, to save and export fields, loader, to read
     * schemata from files, and rules to compute execution.
     *
     * @param writer             writer used to save fields on files.
     * @param environment builder used to instantiate the environment.
     */
    public Controller(EnvironmentWriter writer, Environment environment) {
        this.writer = writer;
        //this.environmentBuilder = environmentBuilder;
        this.currentField = environment;
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
}
