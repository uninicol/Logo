package it.unicam.cs.pa.logo.instructions.interpreter;

import it.unicam.cs.pa.logo.TwoDimEnvironment;
import it.unicam.cs.pa.logo.instructions.BackwardInstruction;
import it.unicam.cs.pa.logo.instructions.ForwardInstruction;
import it.unicam.cs.pa.logo.instructions.Instruction;

import java.util.Objects;
import java.util.Queue;

public class ToEnvironmentInterpreter implements Interpreter<TwoDimEnvironment> {
    TwoDimEnvironment environment;

    public ToEnvironmentInterpreter(TwoDimEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void accept(Queue<String> instructions) {
        String ins = instructions.poll();
        Instruction<TwoDimEnvironment> command =null;
        switch (Objects.requireNonNull(ins)) {
            case "FORWARD" -> command = new ForwardInstruction(environment);
            case "BACKWARD" -> command = new BackwardInstruction(environment);
        }
        if (command == null) throw new RuntimeException("Comando non riconosciuto");
        command.execute(command.getAttributes(instructions));
    }
}
