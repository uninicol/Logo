package it.unicam.cs.pa.logo.model;

import it.unicam.cs.pa.logo.model.defined.TwoDimCoordinate;
import it.unicam.cs.pa.logo.model.defined.TwoDimDrawer;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.defined.TwoDimSegment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    Environment environment;
    Drawer drawer;
    @BeforeEach
    void build (){
        environment=new TwoDimEnvironment(1000,1000);
        drawer=new TwoDimDrawer();
    }

    @Test
    void drawSegmentTest(){
        drawer.drawLine(environment, 90);
        environment.getCursor().setPlot(false);
        drawer.drawLine(environment,90);
        environment.getCursor().setPlot(true);
        drawer.drawLine(environment,90);
       assertEquals(2, environment.getShapes().size());
    }

    @Test
    void drawLine() {
        TwoDimSegment s1 = new TwoDimSegment(new TwoDimCoordinate(50, 50), new TwoDimCoordinate(60, 60));
        drawer.drawLine(environment,s1);
        TwoDimSegment s2 = new TwoDimSegment(new TwoDimCoordinate(60, 60), new TwoDimCoordinate(70, 70));
        drawer.drawLine(environment,s2);
        environment.getCursor().setPlot(false);
        TwoDimSegment s3 = new TwoDimSegment(new TwoDimCoordinate(70, 70), new TwoDimCoordinate(80, 80));
        drawer.drawLine(environment,s3);
        assertEquals(1, environment.getShapes().size());
        assertEquals(2, environment.getShapes().get(0).numSegments());
        environment.getCursor().setPlot(true);
        TwoDimSegment s4 = new TwoDimSegment(new TwoDimCoordinate(80, 80), new TwoDimCoordinate(90, 90));
        drawer.drawLine(environment,s4);
        assertEquals(2, environment.getShapes().size());
    }

}