package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.Segment;
import it.unicam.cs.pa.logo.model.Shape;
import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimDirection;

import java.awt.*;

/**
 * Classe usata per rappresentare un'environment di due dimensioni in una stringa
 */
public class TwoDimEnvWriter implements EnvironmentWriter<TwoDimCoordinate, TwoDimDirection> {
/*
    @Override
    public static String stringOf(Environment<TwoDimCoordinate, TwoDimDirection> field) {
        String str = "SIZE " + field.getLength() + " "
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

 */

    /**
     * Restituisce la rappresentazione testuale di una shape
     *
     * @param shape la shape da rappresentare
     * @return la rappresentazione testuale di una shape
     */
    private String stringOf(Shape<TwoDimCoordinate> shape) {
        if (shape.getSegments().size() == 1)
            return stringOfSingleSegment(shape.getSegments().get(0));
        return "POLYGON " + shape.numSegments() + " "
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
    private String stringOfSingleSegment(Segment<TwoDimCoordinate> segment) {
        return "LINE " + segment.getStartPoint().getX() + " "
                + segment.getStartPoint().getY() + " "
                + segment.getEndPoint().getX() + " "
                + segment.getEndPoint().getY() + " "
                + stringOf(segment.getColor())
                + segment.getSize() + "\n";
    }

    /**
     * Restituisce la stringa che rappresenta gli attributi di un segmento
     *
     * @param segment il segmento
     * @return la stringa che rappresenta gli attributi di un segmento
     */
    private String stringOfSegmentAttributes(Segment<TwoDimCoordinate> segment) {
        return segment.getStartPoint().getX() + " "
                + segment.getStartPoint().getY() + " "
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

    @Override
    public String stringOf(Environment<TwoDimCoordinate, TwoDimDirection> field) {
        return null;
    }
}