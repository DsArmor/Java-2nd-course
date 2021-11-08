package ex4;

import java.util.HashMap;

public class Variable implements IOperator {

    private final Character name;
    private double value;

    public Variable(Character name) {
        this.name = name;
    }

    @Override
    public double evaluate(HashMap<Character, Double> dict) {
        this.value = dict.get(name);
        return (this.value);
    }
}
