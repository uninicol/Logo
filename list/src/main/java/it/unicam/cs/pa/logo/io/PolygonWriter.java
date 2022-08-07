package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Polygon;

public class PolygonWriter implements EnvironmentWriter<Polygon> {

    @Override
    public String stringOf(Polygon polygon) {
        SegmentWriter writer = new SegmentWriter();
        if (polygon.size() == 1 || !polygon.isClosed())
            return "" + polygon.getSegments().stream()
                    .map(writer::stringOf)
                    .toList();
        return "POLYGON " + polygon.size() + " "
                + new SimpleEnvWriter().stringOf(polygon.getBackgroundColor()) + "\n"
                + polygon.getSegments().stream()
                .map(writer::stringOfSegmentAttributes).toList();
    }
}
