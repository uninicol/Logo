package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.AbstractSegment;

import java.awt.*;

/**
 * Classe che rappresenta un segmento in un piano bidimensionale
 */
public class TwoDimSegment extends AbstractSegment {
    public TwoDimSegment(Point startPoint, Point endPoint, Color color) {
        super(startPoint, endPoint, color);
    }

    public TwoDimSegment(Point startPoint, Point endPoint) {
        super(startPoint, endPoint, Color.BLACK);
    }

    public TwoDimSegment(Point startPoint, Point endPoint, Color color, int size) {
        super(startPoint, endPoint, color, size);
    }
}
