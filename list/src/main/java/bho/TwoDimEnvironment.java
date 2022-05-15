package bho;

import it.unicam.cs.pa.logo.Cursor;
import it.unicam.cs.pa.logo.Environment;
import it.unicam.cs.pa.logo.Segment;

import java.util.List;

public class TwoDimEnvironment implements Environment<TwoDimCoordinate> {
    @Override
    public List<Segment<TwoDimCoordinate>> getSegments() {
        return null;
    }

    @Override
    public Segment<TwoDimCoordinate> drawSegment(Cursor cursor, TwoDimCoordinate c1, TwoDimCoordinate c2) {
        return null;
    }
}