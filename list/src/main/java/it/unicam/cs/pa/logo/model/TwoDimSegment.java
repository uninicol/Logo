package it.unicam.cs.pa.logo.model;

import java.util.function.Function;

/**
 * Classe che rappresenta un segmento in un piano bidimensionale
 */
public class TwoDimSegment extends AbstractSegment<TwoDimCoordinate> {
    public TwoDimSegment(TwoDimCoordinate startPoint, TwoDimCoordinate endPoint) {
        super(startPoint, endPoint, x -> (
                        (x - startPoint.xAxis()) / (endPoint.xAxis() - startPoint.xAxis())
                                * (endPoint.yAxis() - startPoint.yAxis())
                )//linea dritta
        );
    }

    public TwoDimSegment(TwoDimCoordinate startPoint, TwoDimCoordinate endPoint, Function<Integer, Integer> function) {
        super(startPoint, endPoint, function);
    }

    public TwoDimSegment(TwoDimCoordinate startPoint, TwoDimCoordinate endPoint, Function<Integer, Integer> function, int size) {
        super(startPoint, endPoint, function, size);
    }
}
