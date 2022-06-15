package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.model.defined.TwoDimEnvironment;
import it.unicam.cs.pa.logo.model.instructions.AbstractInstruction;
import it.unicam.cs.pa.logo.model.instructions.TwoDimInstructionFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe che rappresenta l'istruzione REPEAT
 */
public final class RepeatInstruction extends AbstractInstruction<TwoDimEnvironment> {

    public RepeatInstruction(TwoDimEnvironment environment) {
        super(1, environment);
    }

    @Override
    public void accept(LinkedList<String> instruction) {
        if (!(instruction.containsAll(List.of("[", "]")))) throw new IllegalArgumentException("Mancate parentesi");
        int num = getAttribute(instruction);
        instruction.removeFirstOccurrence("["); //elimino la prima parentesi quadrata
        //creo una lista delle istruzioni da ripetere
        LinkedList<String> toRepeat = instruction.parallelStream()
                .dropWhile(str -> str.equals("]"))
                .collect(Collectors.toCollection(LinkedList::new));
        instruction.removeAll(toRepeat);
        toRepeat.removeFirstOccurrence("]");
        TwoDimInstructionFactory factory = new TwoDimInstructionFactory(getEnvironment());
        for (int i = 0; i < num; i++) {
            //dato che la lista verrà consumata creo una nuova LinkedList per ogni iterazione
            try {
                factory.execute(new LinkedList<>(toRepeat));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}