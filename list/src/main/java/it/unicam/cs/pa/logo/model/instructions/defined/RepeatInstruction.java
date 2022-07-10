package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.io.InstructionLoader;
import it.unicam.cs.pa.logo.model.defined.Environment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Classe che rappresenta l'istruzione REPEAT, ripete la sequenza di comandi
 */
public final class RepeatInstruction extends Instruction<Environment> {

    public RepeatInstruction(Environment environment) {
        super(environment, 1);
    }

    @Override
    public Environment apply(Queue<String> script) {
        if (!(script.containsAll(List.of("[", "]")))) throw new IllegalArgumentException("Mancate parentesi");
        int num = getAttribute(script);
        script.remove("[");
        //creo una lista delle istruzioni da ripetere
        Queue<String> toRepeat = getScriptToRepeat(script);
        removeToRepeatScript(script, toRepeat);
        for (int i = 0; i < num; i++) {
            //dato che la lista verrà consumata creo una nuova LinkedList per ogni iterazione
            Instruction.EXECUTOR.execute(InstructionLoader.DEFAULT_LOGO_READER, getEnvironment(), new LinkedList<>(toRepeat));
        }
        return getEnvironment();
    }

    private Queue<String> getScriptToRepeat(Queue<String> script) {
        LinkedList<String> repeat = script.stream()
                .takeWhile(str -> !str.equals("]"))
                .collect(Collectors.toCollection(LinkedList::new));
        repeat.add("]");
        return repeat;
    }

    private void removeToRepeatScript(Queue<String> script, Queue<String> toRepeat) {
        for (int i = 0; i < toRepeat.size(); i++)
            script.poll();
    }

    @Override
    public String stringOf(Environment environment) {
        return "ripetute precedenti righe";
    }
}