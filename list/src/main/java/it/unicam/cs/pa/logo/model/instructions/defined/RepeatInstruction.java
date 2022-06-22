package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import it.unicam.cs.pa.logo.model.instructions.InstructionRegistry;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe che rappresenta l'istruzione REPEAT, ripete la sequenza di comandi
 */
public final class RepeatInstruction extends Instruction {

    public RepeatInstruction() {
        super(1);
    }

    @Override
    public Environment apply(Environment environment, LinkedList<String> script) throws IOException {
        if (!(script.containsAll(List.of("[", "]")))) throw new IllegalArgumentException("Mancate parentesi");
        int num = getAttribute(script);
        script.removeFirstOccurrence("["); //elimino la prima parentesi quadrata
        //creo una lista delle istruzioni da ripetere
        LinkedList<String> toRepeat = getScriptToRepeat(script);
        removeToRepeatScript(script, toRepeat);
        for (int i = 0; i < num; i++) {
            //dato che la lista verrà consumata creo una nuova LinkedList per ogni iterazione
            Instruction.EXECUTOR.execute(InstructionRegistry.getTwoDimRegistrySet(), environment, new LinkedList<>(toRepeat));
        }
        return environment;
    }

    private LinkedList<String> getScriptToRepeat(LinkedList<String> script) {
        LinkedList<String> repeat = script.stream()
                .takeWhile(str -> !str.equals("]"))
                .collect(Collectors.toCollection(LinkedList::new));
        repeat.add("]");
        return repeat;
    }

    private void removeToRepeatScript(LinkedList<String> script, LinkedList<String> toRepeat) {
        for (int i = 0; i < toRepeat.size(); i++) {
            script.poll();
        }
    }

    @Override
    public String stringOf(Environment environment) {
        return "ripetuto";
    }
}