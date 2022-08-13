package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.Segment;


public interface SegmentChecker<S extends Segment, E extends Environment<?>> {

    /**
     * Verifica se il segmento è correttamente all'interno dell'environment
     *
     * @param segment     il segmento da disegnare
     * @param environment l'environment
     * @return se il segmento non è totalmente all'interno dell'environment restituisce il segmento corretto
     */
    S check(S segment, E environment);
}
