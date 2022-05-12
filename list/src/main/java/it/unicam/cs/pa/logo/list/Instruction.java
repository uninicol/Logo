package it.unicam.cs.pa.logo.list;

import java.util.function.Function;

/**
 * Questa interfaccia rappresenta un istruzione del linguaggio Logo
 *
 * @param <T>
 */
public interface Instruction<T extends Tag, S extends Shape<? extends Coordinates>> extends Function<T, S> {
}