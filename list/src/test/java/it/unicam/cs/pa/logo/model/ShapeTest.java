package it.unicam.cs.pa.logo.model;

import it.unicam.cs.pa.logo.model.defined.TwoDimDrawer;
import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    Environment environment;
    Drawer drawer;
    @BeforeEach
    void build (){
        environment=new TwoDimEnvironment(1000,1000);
        drawer=new TwoDimDrawer(environment);
    }

    @Test
    void drawSegmentTest(){
        drawer.drawLine(90);
        environment.getCursor().setPlot(false);
        drawer.drawLine(90);
        environment.getCursor().setPlot(true);
        drawer.drawLine(90);
       assertEquals(2, environment.getShapes().size());
    }
}