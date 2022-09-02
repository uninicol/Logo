package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.Queue;

/**
 * Classe che rappresenta l'istruzione CLEARSCREEN, cancella quanto disegnato
 */
public final class ClearscreenInstruction implements Instruction<SimpleEnvironment> {

    @Override
    public String stringOf(SimpleEnvironment environment) {
        return "cancellato le linee tracciate";
    }

    @Override
    public SimpleEnvironment apply(SimpleEnvironment environment, Queue<String> script) {
        environment.clearAll();
        return environment;
    }
}
