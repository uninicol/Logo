package it.unicam.cs.pa.logo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoDimCoordinateTest {

    TwoDimCoordinate point;
    AbstractCursor<TwoDimCoordinate, TwoDimDirection> cursor;

    @BeforeEach
    void build() {
        point = new TwoDimCoordinate(100, 100);
        cursor = new TwoDimCursor(point, new TwoDimDirection());
    }

    @Test
    void getDistanceFromAnglesTest() {
        TwoDimCoordinate UpRight = new TwoDimCoordinate(100 + 50, 100 + 50);
        TwoDimCoordinate UpLeft = new TwoDimCoordinate(100 - 50, 100 + 50);
        TwoDimCoordinate DownRight = new TwoDimCoordinate(100 + 50, 100 - 50);
        TwoDimCoordinate DownLeft = new TwoDimCoordinate(100 - 50, 100 - 50);

        assertEquals(point.getDistanceFrom(UpRight), 70);
        assertEquals(point.getDistanceFrom(UpLeft), 70);
        assertEquals(point.getDistanceFrom(DownRight), 70);
        assertEquals(point.getDistanceFrom(DownLeft), 70);
    }

    @Test
    void getDistanceFromDifferentAnglesTest() {
        TwoDimCoordinate UpRight1 = new TwoDimCoordinate(125, 150);
        TwoDimCoordinate UpRight2 = new TwoDimCoordinate(150, 125);
        TwoDimCoordinate UpLeft1 = new TwoDimCoordinate(-125, 150);
        TwoDimCoordinate UpLeft2 = new TwoDimCoordinate(-150, 125);
        TwoDimCoordinate DownRight1 = new TwoDimCoordinate(125, -150);
        TwoDimCoordinate DownRight2 = new TwoDimCoordinate(150, -125);
        TwoDimCoordinate DownLeft1 = new TwoDimCoordinate(-125, -150);
        TwoDimCoordinate DownLeft2 = new TwoDimCoordinate(-150, -125);

        assertEquals(55, point.getDistanceFrom(UpRight1));
        assertEquals(55, point.getDistanceFrom(UpRight2));
        assertEquals(55, point.getDistanceFrom(UpLeft1));
        assertEquals(55, point.getDistanceFrom(UpLeft2));
        assertEquals(55, point.getDistanceFrom(DownRight1));
        assertEquals(55, point.getDistanceFrom(DownRight2));
        assertEquals(55, point.getDistanceFrom(DownLeft1));
        assertEquals(55, point.getDistanceFrom(DownLeft2));
    }

    @Test
    void getCoordinateFromDistance() {
        TwoDimCoordinate Right = new TwoDimCoordinate(100 + 50, 100);
        TwoDimCoordinate Down = new TwoDimCoordinate(100, 100 - 50);
        TwoDimCoordinate Left = new TwoDimCoordinate(100 - 50, 100);
        TwoDimCoordinate Up = new TwoDimCoordinate(100, 100 + 50);

        assertEquals(Right, point.getCoordinateFromDistance(50, cursor));
        cursor.getDirection().increaseDirection(90);
        assertEquals(Down, point.getCoordinateFromDistance(50, cursor));

        cursor.getDirection().increaseDirection(90);
        assertEquals(Left, point.getCoordinateFromDistance(50, cursor));

        cursor.getDirection().increaseDirection(90);
        assertEquals(Up, point.getCoordinateFromDistance(50, cursor));
    }
}