package it.unicam.cs.pa.logo.model.instructions;

import it.unicam.cs.pa.logo.io.InstructionReader;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Stream;

public class LOGOExecutor implements Executor<Instruction<SimpleEnvironment>, SimpleEnvironment> {

    //private final List<SimpleEnvironment> updates = new LinkedList<>();

    @Override
    public SimpleEnvironment execute(InstructionReader<Instruction<SimpleEnvironment>, SimpleEnvironment> registry, SimpleEnvironment environment, Queue<String> script) {
        Queue<String> scriptCopy = new LinkedList<>(script); //creo un clone altrimenti ho ConcurrentModificationException nello stream
        Stream.concat(
                        script.stream().takeWhile(str -> !str.equals("[")),//elimino lo script all'interno delle parentesi
                        script.stream().dropWhile(str -> !str.equals("]")) //problemi con inner loop
                )
                .map(str -> registry.parse(str, environment))
                .filter(Optional::isPresent)
                .forEach(instruction -> {
                    scriptCopy.poll();
                    SimpleEnvironment env = instruction.get().apply(scriptCopy);
                    //updates.add((SimpleEnvironment) env.clone());
                });
        return environment;
    }
}
