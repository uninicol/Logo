package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.Polygon;
import it.unicam.cs.pa.logo.model.Segment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Questa è un'interfaccia funzionale usata per scrivere l'ambiente in una stringa
 */
public interface EnvironmentWriter<E extends Environment<?>> {

    /**
     * Restituisce la stringa che rappresenta l'ambiente dato
     *
     * @param field un ambiente.
     * @return la stringa che rappresenta l'ambiente.
     */
    String stringOf(E field);

    /**
     * Restituisce una stringa che rappresenta un poligono
     *
     * @param polygon il poligono
     * @return la stringa che rappresenta un poligono
     */
    String stringOf(Polygon polygon);

    /**
     * Restituisce una stringa che rappresenta un segmento
     *
     * @param segment il segmento
     * @return la stringa che rappresenta un segmento
     */
    String stringOf(Segment segment);

    /**
     * Scrive l'ambiente dato in un file con riferimento al path dato
     *
     * @param path  il path dove l'ambiente è salvato
     * @param field l'ambiente da scrivere
     * @throws IOException se si verifica un errore di I/O durante la scrittura del file.
     */
    default void writeTo(Path path, E field) throws IOException {
        Files.write(path, stringOf(field).getBytes());
    }

    /**
     * Scrive l'ambiente dato in un dato file
     *
     * @param file  il file dove l'ambiente è salvato
     * @param field l'ambiente da scrivere
     * @throws IOException se si verifica un errore di I/O durante la scrittura del file.
     */
    default void writeTo(File file, E field) throws IOException {
        writeTo(file.toPath(), field);
    }
}
