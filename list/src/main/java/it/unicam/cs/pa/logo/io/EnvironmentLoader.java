package it.unicam.cs.pa.logo.io;


import it.unicam.cs.pa.logo.model.Coordinate;
import it.unicam.cs.pa.logo.model.Direction;
import it.unicam.cs.pa.logo.model.Environment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Una Interfaccia funzionale usata per leggere l'ambiente da una stringa
 *
 * @param <C> le coordinate
 * @param <D> la direzione
 */
@FunctionalInterface
public interface EnvironmentLoader<C extends Coordinate<C>, D extends Direction<D>> {

    /**
     * Analizza una stringa che contiene un comando del linguaggio LOGO
     *
     * @param content stringa contenente il comando LOGO
     * @return l'ambiente associata alla stringa data
     * @throws IOException se la stringa non è ben formata
     */
    Environment<C, D> parse(String content) throws IOException;


    /**
     * Restituisce l'ambiente memorizzato nel file a cui fa riferimento il percorso indicato.
     *
     * @param path un path al file contenente il istruzioni LOGO.
     * @return l'ambiente descritto dal file a cui fa riferimento il percorso dato.
     * @throws IOException se si verifica un errore di I/O durante la lettura del file o se viene letta una sequenza di byte malformata o non applicabile.
     */
    default Environment<C, D> parse(Path path) throws IOException {
        return parse(Files.readString(path));
    }

    /**
     * Restituisce l'ambiente memorizzato nel file indicato.
     *
     * @param file un file contenente un ambiente LOGO
     * @return l'ambiente descritto nel file a cui fa riferimento il percorso dato.
     * @throws IOException se si verifica un errore di I/O nella lettura del file o se viene letta una sequenza di byte malformata o non applicabile.
     */
    default Environment<C, D> parse(File file) throws IOException {
        return parse(file.toPath());
    }

}