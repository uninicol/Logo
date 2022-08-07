package it.unicam.cs.pa.logo.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Questa è un'interfaccia funzionale usata per scrivere un componente di un ambiente in una stringa
 */
@FunctionalInterface
public interface EnvironmentWriter<T> {

    /**
     * Restituisce la stringa che rappresenta l'argomento
     *
     * @param field un elemento dell'environment
     * @return la stringa che rappresenta l'ambiente.
     */
    String stringOf(T field);

    /**
     * Scrive l'ambiente dato in un file con riferimento al path dato
     *
     * @param path  il path dove l'ambiente è salvato
     * @param field l'ambiente da scrivere
     * @throws IOException se si verifica un errore di I/O durante la scrittura del file.
     */
    default void writeTo(Path path, T field) throws IOException {
        Files.write(path, stringOf(field).getBytes());
    }

    /**
     * Scrive l'ambiente dato in un dato file
     *
     * @param file  il file dove l'ambiente è salvato
     * @param field l'ambiente da scrivere
     * @throws IOException se si verifica un errore di I/O durante la scrittura del file.
     */
    default void writeTo(File file, T field) throws IOException {
        writeTo(file.toPath(), field);
    }
}
