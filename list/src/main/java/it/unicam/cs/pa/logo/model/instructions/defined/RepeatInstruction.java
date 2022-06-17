package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.Environment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;
import it.unicam.cs.pa.logo.model.instructions.InstructionExecutor;

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
    public Environment apply(Environment environment, LinkedList<String> script) {
        if (!(script.containsAll(List.of("[", "]")))) throw new IllegalArgumentException("Mancate parentesi");
        int num = getAttribute(script);
        script.removeFirstOccurrence("["); //elimino la prima parentesi quadrata
        //creo una lista delle istruzioni da ripetere
        LinkedList<String> toRepeat = script.parallelStream()
                .dropWhile(str -> str.equals("]"))
                .collect(Collectors.toCollection(LinkedList::new));
        script.removeAll(toRepeat);
        toRepeat.removeFirstOccurrence("]");
        InstructionExecutor executor = new InstructionExecutor(environment, script);
        for (int i = 0; i < num; i++) {
            //dato che la lista verrà consumata creo una nuova LinkedList per ogni iterazione
            executor.execute(new LinkedList<>(toRepeat));
        }
        return environment;
    }
}