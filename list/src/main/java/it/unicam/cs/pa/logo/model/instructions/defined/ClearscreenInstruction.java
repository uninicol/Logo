package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione CLEARSCREEN, cancella quanto disegnato
 */
public final class ClearscreenInstruction extends Instruction<SimpleEnvironment> {
    public ClearscreenInstruction(SimpleEnvironment environment) {
        super(environment, 0);
    }

    @Override
    public SimpleEnvironment apply(Queue<String> script) {
        getEnvironment().clearAll();
        return getEnvironment();
    }

    @Override
    public String stringOf(SimpleEnvironment environment) {
        return "cancellato le linee tracciate";
    }
}
