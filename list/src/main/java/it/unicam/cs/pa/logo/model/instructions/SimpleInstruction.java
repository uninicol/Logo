package it.unicam.cs.pa.logo.model.instructions;

//public class SimpleInstruction implements Instruction {
//
//    private final int numOfAttributes;
//    private int requestedAttributes;
//    private final BiFunction<LinkedList<String>, Environment, Environment> behavior;
//
//    public SimpleInstruction(int numOfAttributes, BiFunction<LinkedList<String>, Environment, Environment> behavior) {
//        this.numOfAttributes = numOfAttributes;
//        this.behavior = behavior;
//        this.requestedAttributes = 0;
//    }
//
//    @Override
//    public int getRequiredAttributesNumber() {
//        return numOfAttributes;
//    }
//
//    @Override
//    public int getCountRequestedAttributes() {
//        return requestedAttributes;
//    }
//
//    @Override
//    public void setCountRequestedAttributes(int number) {
//        this.requestedAttributes = number;
//    }
//
//    @Override
//    public Environment apply(LinkedList<String> strings, Environment environment) {
//        return behavior.apply(strings, environment);
//    }
//
//    @Override
//    public Environment apply(Environment environment, LinkedList<String> script) {
//        return null;
//    }
//}
