//package it.unicam.cs.pa.logo.model.defined;
//
//import it.unicam.cs.pa.logo.model.Drawer;
//import it.unicam.cs.pa.logo.model.Polygon;
//import it.unicam.cs.pa.logo.model.Segment;
//
//import java.awt.*;
//import java.awt.geom.Point2D;
//
//public class SegmentDrawer implements Drawer<Segment, SimpleEnvironment> {
//
//    private final SimpleEnvironment environment;
//
//    public SegmentDrawer(SimpleEnvironment environment) {
//        this.environment = environment;
//    }
//
//    @Override
//    public SimpleEnvironment draw(Segment segment) {
//        checkSegment(segment, segment.getP1().distance(segment.getP2()));
//        if (environment.getCursor().isPlot())
//            draw(segment);
//        environment.getCursor().moveTo(segment.getP2());
//        return insertInPolygon();
//    }
//
//    /**
//     * Inserisce il segmento nella lista di poligoni dell'environment
//     *
//     * @return l'environment aggiornato
//     */
//    private SimpleEnvironment insertInPolygon() {
//        if (environment.getPolygons().isEmpty()) return environment;
//        Polygon lastPolygon = environment.getPolygons().get(environment.getPolygons().size() - 1);
//        if (lastPolygon.isClosed())
//            lastPolygon.setBackgroundColor(environment.getCursor().getAreaColor());
//        return environment;
//    }
//
//    /**
//     * Traccia una linea di una determinata lunghezza
//     *
//     * @param length la lunghezza della linea
//     */
//    public void draw(int length) {
//
//        draw(segment);
//    }
//
//    /**
//     * Verifica se il segmento è correttamente all'interno dell'environment
//     *
//     * @param segment il segmento
//     * @param length  la lunghezza del segmento
//     */
//    private void checkSegment(Segment segment, double length) {
//        int x = (int) segment.getP2().getX();
//        int y = (int) segment.getP2().getY();
//        Point point = new Point(x, y);
//        if (!(environment.contains(point)))
//            checkPoint(point, length);
//    }
//
//
//
//    /**
//     * Verifica se le point ottenute sono all'interno dell'environment
//     *
//     * @param point    le point da verificare
//     * @param distance la distanza tra la coordinata di partenza e di fine
//     * @return la coordinata all'interno dell'environment
//     */
//    private Point checkPoint(Point point, double distance) {
//        double distanceDifference = getDistanceDifference(point);
//        return getPointFromDistance(Math.abs(distance - Math.abs(distanceDifference)));
//    }
//
//    /**
//     * Restituisce la lunghezza tra la coordinata e il bordo dell'environment
//     *
//     * @param point le point fuori dall'environment
//     * @return la differenza tra il punto fuori e quello all'interno dell'environment
//     */
//    private double getDistanceDifference(Point point) {
//        double distanceDifference = checkX(point.getX());
//        if (distanceDifference != 0)
//            return distanceDifference;
//        else return checkY(point.getY());
//    }
//
//    /**
//     * Controlla se il punto x è all'interno dell'environment
//     *
//     * @param x il punto x
//     * @return il punto x all'interno dell'environment
//     */
//    private double checkX(double x) {
//        double angle = environment.getCursor().getDirection().getValue();
//        if (x > environment.getWidth())
//            return ((x - environment.getWidth()) / Math.cos(Math.toRadians(angle)));
//        else if (x < 0)
//            return (Math.abs(x) / Math.cos(Math.toRadians(angle)));
//        return 0;
//    }
//
//    /**
//     * Controlla se il punto y è all'interno dell'environment
//     *
//     * @param y il punto y
//     * @return il punto y all'interno dell'environment
//     */
//    private double checkY(double y) {
//        double angle = environment.getCursor().getDirection().getValue();
//        if (y > environment.getHeight())
//            if (angle == 270) return y - environment.getHeight();
//            else return ((y - environment.getHeight()) / Math.cos(Math.toRadians(angle)));
//        else if (y < 0)
//            if (angle == 90) return Math.abs(y);
//            else return (Math.abs(y) / Math.cos(Math.toRadians(angle)));
//        return 0;
//    }
//
//}
