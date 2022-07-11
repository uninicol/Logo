package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Segment;
import it.unicam.cs.pa.logo.model.Shape;
import it.unicam.cs.pa.logo.model.defined.Environment;

import java.awt.*;

/**
 * Classe usata per rappresentare un'environment di due dimensioni in una stringa
 */
public class SimpleEnvWriter implements EnvironmentWriter {

    @Override
    public String stringOf(Environment field) {
        String str = "SIZE " + field.getWidth() + " "
                + field.getHeight() + " "
                + stringOf(field.getBackgroundColor()) + "\n"
                + field.getShapes().stream()
                .map(this::stringOf)
                .toList();
        str = str.replaceAll("\\[", "")
                .replaceAll("]", "")
                .replaceAll(", ", "");
        return str;
    }

    /**
     * Restituisce la rappresentazione testuale di una shape
     *
     * @param shape la shape da rappresentare
     * @return la rappresentazione testuale di una shape
     */
    private String stringOf(Shape shape) {
        if (shape.size() == 1)
            return stringOfSingleSegment(shape.getSegments().get(0));
        return "POLYGON " + shape.size() + " "
                + stringOf(shape.getBackgroundColor()) + "\n"
                + shape.getSegments().stream()
                .map(this::stringOfSegmentAttributes).toList();
    }

    /**
     * Restituisce la stringa che rappresenta un segmento
     *
     * @param segment il segmento
     * @return la stringa che rappresenta un segmento
     */
    private String stringOfSingleSegment(Segment segment) {
        return "LINE " + segment.getX1() + " "
                + segment.getY1() + " "
                + segment.getX2() + " "
                + segment.getY2() + " "
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
        return segment.getX1() + " "
                + segment.getY1() + " "
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