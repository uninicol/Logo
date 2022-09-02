package it.unicam.cs.pa.logo.model.instructions.defined;

import it.unicam.cs.pa.logo.io.InstructionLoader;
import it.unicam.cs.pa.logo.model.defined.SimpleEnvironment;
import it.unicam.cs.pa.logo.model.instructions.Instruction;
import it.unicam.cs.pa.logo.model.instructions.LOGOExecutor;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Classe che rappresenta l'istruzione REPEAT, ripete la sequenza di comandi
 */
public final class RepeatInstruction implements Instruction<SimpleEnvironment> {

    @Override
    public String stringOf(SimpleEnvironment environment) {
        return "ripetute precedenti righe";
    }

    @Override
    public SimpleEnvironment apply(SimpleEnvironment environment, Queue<String> script) {
        if (!(script.containsAll(List.of("[", "]")))) throw new IllegalArgumentException("Mancate parentesi");
        int num = getIntegerAttribute(script);
        script.remove("[");
        //creo una lista delle istruzioni da ripetere
        Queue<String> toRepeat = getScriptToRepeat(script);
        removeToRepeatScript(script, toRepeat);
        for (int i = 0; i < num; i++) {
            //dato che la lista verrà consumata creo una nuova LinkedList per ogni iterazione
            LOGOExecutor.LOGO_EXECUTOR.execute(InstructionLoader.DEFAULT_LOGO_READER, environment, new LinkedList<>(toRepeat));
        }
        return environment;
    }

    /**
     * In caso istrutioni REPEAT all'interno del blocco, seleziona l'indice della sua parentesi di chiusura
     *
     * @param script lo script
     * @return l'indice della parentesi chiusa del REPEAT
     */
    private int lastClosedBracketIndex(Queue<String> script) {
        List<Integer> indexes = new LinkedList<>();
        int openParenthesis = 0;
        int i = 0;
        for (String str : script) {
            if (str.equals("["))
                openParenthesis++;
            if (str.equals("]"))
                indexes.add(i);
            i++;
        }
        return indexes.get(openParenthesis);
    }

    /**
     * Rimuove dallo script originale lo script che verrà ripetuto
     *
     * @param script   lo script originale
     * @param toRepeat lo script da ripetere
     */
    private void removeToRepeatScript(Queue<String> script, Queue<String> toRepeat) {
        for (int i = 0; i < toRepeat.size(); i++)
            script.poll();
    }

    /**
     * Restituisce lo script che verrà ripetuto
     *
     * @param script lo script originale
     * @return lo script che verrà ripetuto
     */
    private Queue<String> getScriptToRepeat(Queue<String> script) {
        LinkedList<String> repeat = script.stream()
                .limit(lastClosedBracketIndex(script))
                .collect(Collectors.toCollection(LinkedList::new));
        repeat.add("]");
        return repeat;
    }
}