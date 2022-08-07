package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.Segment;

public class SegmentWriter implements EnvironmentWriter<Segment> {

    @Override
    public String stringOf(Segment segment) {
        return "LINE " + (int) segment.getX1() + " "
                + (int) segment.getY1() + " "
                + (int) segment.getX2() + " "
                + (int) segment.getY2() + " "
                + new SimpleEnvWriter().stringOf(segment.getColor())
                + segment.getSize() + "\n";
    }

    /**
     * Restituisce la stringa che rappresenta gli attributi di un segmento
     *
     * @param segment il segmento
     * @return la stringa che rappresenta gli attributi di un segmento
     */
    public String stringOfSegmentAttributes(Segment segment) {
        return (int) segment.getX1() + " "
                + (int) segment.getY1() + " "
                + new SimpleEnvWriter().stringOf(segment.getColor())
                + segment.getSize() + "\n";
    }
}
