package it.unicam.cs.pa.logo.io;

import it.unicam.cs.pa.logo.model.defined.Direction360;
import it.unicam.cs.pa.logo.model.defined.SimpleCursor;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleEnvWriterTest {

    EnvironmentWriter<SimpleEnvironment> writer = new SimpleEnvWriter();

    @Test
    void stringOf() {
        SimpleEnvironment environment = new SimpleEnvironment(1000, 1000, new SimpleCursor(new Point(500, 500), new Direction360()));
        assertEquals("SIZE 1000 1000 255 255 255\n", writer.stringOf(environment));
    }
}