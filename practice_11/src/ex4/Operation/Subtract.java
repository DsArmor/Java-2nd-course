package ex4.Operation;

import ex4.BinaryOperation;
import ex4.IOperator;

import java.util.HashMap;

public class Subtract extends BinaryOperation {

    public Subtract(IOperator first, IOperator second) {
        super(first, second);
    }

    @Override
    public double evaluate(HashMap<Character, Double> dict){
        return (getFirst().evaluate(dict) - getSecond().evaluate(dict));
    }
}
