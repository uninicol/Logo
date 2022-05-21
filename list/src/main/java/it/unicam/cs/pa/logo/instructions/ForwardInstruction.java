package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.TwoDimEnvironment;

import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class ForwardInstruction extends AbstractInstruction<TwoDimEnvironment> {
    public ForwardInstruction(TwoDimEnvironment environment) {
        super("FORWARD", 1, environment);
    }

    @Override
    public void execute(List<Integer> instruction) {
        //determino il punto di arrivo con dovuti limiti

        if(getEnvironment().getCursor().isPlot()) {
            //inserisce il tratto nell'env
        }else{
            //altrimenti si sposta solo (posso eliminare l'else)
        }

    }


//    @Override
//    public void accept(Queue<String> strings, TwoDimEnvironment env) {
//        strings.poll();//estraggo la stringa del comando TODO posso farlo nel interprete
//        if (env.getCursor().getPlot()){
//            //disegna
//            env.drawSegment();
//        }
//        else {
//            //si sposta senza disegnare
//        }
//
//}
}
