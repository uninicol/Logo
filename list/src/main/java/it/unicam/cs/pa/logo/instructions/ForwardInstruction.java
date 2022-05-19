package it.unicam.cs.pa.logo.instructions;

import it.unicam.cs.pa.logo.TwoDimEnvironment;

import java.util.Queue;

public class ForwardInstruction extends AbstractInstruction<TwoDimEnvironment> {

    protected ForwardInstruction(String name, int numAttributes) {
        super(name, numAttributes);
    }

    @Override
    public void accept(Queue<String> strings, TwoDimEnvironment environment) {

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
