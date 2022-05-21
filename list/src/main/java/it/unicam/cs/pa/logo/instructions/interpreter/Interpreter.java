package it.unicam.cs.pa.logo.instructions.interpreter;

import it.unicam.cs.pa.logo.Coordinate;
import it.unicam.cs.pa.logo.Environment;
import it.unicam.cs.pa.logo.instructions.ForwardInstruction;
import it.unicam.cs.pa.logo.instructions.Instruction;

import java.util.Collection;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Rappresenta un interprete di comandi
 */
public interface Interpreter<R> extends Consumer<Queue<String>> {

}
