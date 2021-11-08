package ex4;

import java.util.HashMap;

public class Const implements IOperator {

    double value;

    public Const(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(HashMap<Character, Double> dict) {
        return value;
    }
}
