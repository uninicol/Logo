package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.LinkedList;

/**
 * Classe che rappresenta l'istruzione CLEARSCREEN, cancella quanto disegnato
 */
public final class ClearscreenInstruction extends Instruction {
    public ClearscreenInstruction() {
        super(0);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) {
        environment.clearAll();
        return environment;
    }

    @Override
    public String stringOf(Environment environment) {
        return "cancellato le linee tracciate";
    }
}
