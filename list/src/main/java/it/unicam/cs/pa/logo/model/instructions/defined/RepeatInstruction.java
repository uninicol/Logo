package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;
import it.unicam.cs.pa.logo.model.instructions.InstructionExecutor;
import it.unicam.cs.pa.logo.model.instructions.InstructionRegistry;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe che rappresenta l'istruzione REPEAT, ripete la sequenza di comandi
 */
public final class RepeatInstruction extends AbstractInstruction {

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
        script.removeAll(toRepeat);
        toRepeat.removeFirstOccurrence("]");
        for (int i = 0; i < num; i++) {
            //dato che la lista verrà consumata creo una nuova LinkedList per ogni iterazione
            new InstructionExecutor(InstructionRegistry.getTwoDimRegistrySet(), environment, new LinkedList<>(toRepeat))
                    .executeScript();
        }
        return environment;
    }

    private LinkedList<String> getScriptToRepeat(LinkedList<String> script) {
        return script.parallelStream()
                .dropWhile(str -> str.equals("]"))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public String stringOf(Environment environment) {
        return "";
    }
}