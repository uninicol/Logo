package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.AbstractSegment;
import it.unicam.cs.pa.logo.model.Coordinate;

import java.awt.*;

/**
 * Classe che rappresenta un segmento in un piano bidimensionale
 */
public class TwoDimSegment extends AbstractSegment {
    public TwoDimSegment(Coordinate startPoint, Coordinate endPoint, Color color) {
        super(startPoint, endPoint, color);
    }

    public TwoDimSegment(Coordinate startPoint, Coordinate endPoint) {
        super(startPoint, endPoint, Color.BLACK);
    }

    public TwoDimSegment(Coordinate startPoint, Coordinate endPoint, Color color, int size) {
        super(startPoint, endPoint, color, size);
    }
}
