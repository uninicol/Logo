package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Coordinate;
import it.unicam.cs.pa.logo.model.Direction;
import it.unicam.cs.pa.logo.model.Environment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Questa è un'interfaccia funzionale usata per scrivere l'ambiente in una stringa
 *
 * @param <C> le coordinate
 * @param <D> la direzione
 */
@FunctionalInterface
public interface EnvironmentWriter<C extends Coordinate, D extends Direction> {

    //static String stringOf(Environment<TwoDimCoordinate, TwoDimDirection> field);

    /**
     * Restituisce la stringa che rappresenta l'ambiente dato
     *
     * @param field un ambiente.
     * @return la stringa che rappresenta l'ambiente.
     */
    String stringOf(Environment<C, D> field);

    /**
     * Scrive l'ambiente dato in un file con riferimento al path dato
     *
     * @param path  il path dove l'ambiente è salvato
     * @param field l'ambiente da scrivere
     * @throws IOException se si verifica un errore di I/O durante la scrittura del file.
     */
    default void writeTo(Path path, Environment<C, D> field) throws IOException {
        Files.write(path, stringOf(field).getBytes());
    }

    /**
     * Scrive l'ambiente dato in un dato file
     *
     * @param file  il file dove l'ambiente è salvato
     * @param field l'ambiente da scrivere
     * @throws IOException se si verifica un errore di I/O durante la scrittura del file.
     */
    default void writeTo(File file, Environment<C, D> field) throws IOException {
        writeTo(file.toPath(), field);
    }
}
