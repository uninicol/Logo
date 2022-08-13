package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;

import java.awt.*;

/**
 * Classe usata per rappresentare un'environment di due dimensioni in una stringa
 */
public class SimpleEnvWriter implements EnvironmentWriter<SimpleEnvironment> {

    @Override
    public String stringOf(SimpleEnvironment field) {
        PolygonWriter polygonWriter = new PolygonWriter();
        return "SIZE " +
                field.getWidth() + " " +
                field.getHeight() + " " +
                stringOf(field.getBackgroundColor()) + "\n" +
                field.getPolygons().stream()
                        .map(polygonWriter::stringOf)
                        .toList()
                        .toString().replaceAll("\\[|]|, ", "");
    }

    /**
     * Restituisce la stringa che rappresenta il colore nel formato RGB
     *
     * @param color il colore da rappresentare
     * @return la stringa che rappresenta il colore nel formato RGB
     */
    public String stringOf(Color color) {
        return color.getRed() + " "
                + color.getGreen() + " "
                + color.getBlue();
    }
}