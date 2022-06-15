package it.unicam.cs.pa.logo.model.defined;

import it.unicam.cs.pa.logo.model.AbstractSegment;

import java.awt.*;
import java.util.function.Function;

/**
 * Classe che rappresenta un segmento in un piano bidimensionale
 */
public class TwoDimSegment extends AbstractSegment<TwoDimCoordinate> {
    public TwoDimSegment(TwoDimCoordinate startPoint, TwoDimCoordinate endPoint, Color color) {
        super(startPoint, endPoint, color, x -> (
                        (x - startPoint.xAxis()) / (endPoint.xAxis() - startPoint.xAxis())
                                * (endPoint.yAxis() - startPoint.yAxis())
                )//linea dritta
        );
    }

    public TwoDimSegment(TwoDimCoordinate startPoint, TwoDimCoordinate endPoint) {
        super(startPoint, endPoint, Color.BLACK, x -> (
                        (x - startPoint.xAxis()) / (endPoint.xAxis() - startPoint.xAxis())
                                * (endPoint.yAxis() - startPoint.yAxis())
                )//linea dritta
        );
    }

    public TwoDimSegment(TwoDimCoordinate startPoint, TwoDimCoordinate endPoint, Color color, Function<Integer, Integer> function) {
        super(startPoint, endPoint, color, function);
    }

    public TwoDimSegment(TwoDimCoordinate startPoint, TwoDimCoordinate endPoint, Color color, Function<Integer, Integer> function, int size) {
        super(startPoint, endPoint, color, function, size);
    }
}
