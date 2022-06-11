package it.unicam.cs.pa.logo;

import it.unicam.cs.pa.logo.model.TwoDimEnvironment;
import org.junit.jupiter.api.BeforeEach;


class TwoDimEnvironmentTest {
    TwoDimEnvironment env;

    @BeforeEach
    void build() {
        env = new TwoDimEnvironment(100, 100);
    }
}