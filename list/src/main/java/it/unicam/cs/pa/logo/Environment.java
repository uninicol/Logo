package it.unicam.cs.pa.logo;

import java.util.List;

/**
 * Classe usata per tenere traccia delle linee disegnate
 *
 * @param <C> le coordinate
 */
public interface Environment<C extends Coordinate> {
/*
    /**
     * La lista di figure
     *//*
    private final List<Shape<C>> shapes;

    private Color backgroudColor = Color.WHITE;

    public Environment(List<Shape<C>> shapes) {
        this.shapes = shapes;
    }

    public List<Shape<C>> getShapes() {
        return shapes;
    }

    public void addShape(Shape<C> shape) {
        shapes.add(shape);
    }

    public void clearAll() {
        shapes.clear();
    }
*/

    /**
     * Restituisce la lista di tutti i segmenti nell'ambiente
     *
     * @return la lista di segmenti nell'ambiente
     */
    List<Segment<C>> getSegments();

    /**
     * Disegna una linea nell'ambiente
     *
     * @param cursor il cursore
     * @param c1     la coordinata di partenza
     * @param c2     la coordinata di arrivo
     * @return il segmento
     */
    Segment<C> drawSegment(Cursor cursor, C c1, C c2);


}