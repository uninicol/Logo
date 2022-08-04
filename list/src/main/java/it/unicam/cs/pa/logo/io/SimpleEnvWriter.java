package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Polygon;
import it.unicam.cs.pa.logo.model.Segment;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;

import java.awt.*;

/**
 * Classe usata per rappresentare un'environment di due dimensioni in una stringa
 */
public class SimpleEnvWriter implements EnvironmentWriter<SimpleEnvironment> {

    @Override
    public String stringOf(SimpleEnvironment field) {
        String str = "SIZE " + (int) field.getWidth() + " "
                + (int) field.getHeight() + " "
                + stringOf(field.getBackgroundColor()) + "\n"
                + field.getPolygons().stream()
                .map(this::stringOf)
                .toList();
        str = str.replaceAll("\\[|\\]|, ", "");
        //.replaceAll("]", "")
        //.replaceAll(", ", "");
        return str;
    }

    @Override
    public String stringOf(Polygon polygon) {
        if (polygon.size() == 1 || !polygon.isClosed())
            return "" + polygon.getSegments().stream()
                    .map(this::stringOf)
                    .toList();
        return "POLYGON " + polygon.size() + " "
                + stringOf(polygon.getBackgroundColor()) + "\n"
                + polygon.getSegments().stream()
                .map(this::stringOfSegmentAttributes).toList();
    }

    @Override
    public String stringOf(Segment segment) {
        return "LINE " + (int) segment.getX1() + " "
                + (int) segment.getY1() + " "
                + (int) segment.getX2() + " "
                + (int) segment.getY2() + " "
                + stringOf(segment.getColor())
                + segment.getSize() + "\n";
    }

    /**
     * Restituisce la stringa che rappresenta gli attributi di un segmento
     *
     * @param segment il segmento
     * @return la stringa che rappresenta gli attributi di un segmento
     */
    private String stringOfSegmentAttributes(Segment segment) {
        return (int) segment.getX1() + " "
                + (int) segment.getY1() + " "
                + stringOf(segment.getColor())
                + segment.getSize() + "\n";
    }

    /**
     * Restituisce la stringa che rappresenta il colore nel formato RGB
     *
     * @param color il colore da rappresentare
     * @return la stringa che rappresenta il colore nel formato RGB
     */
    private String stringOf(Color color) {
        return color.getRed() + " "
                + color.getGreen() + " "
                + color.getBlue() + " ";
    }
}