package ex4.Operation;

import ex4.BinaryOperation;
import ex4.IOperator;

import java.util.HashMap;

public class Divide extends BinaryOperation {

    public Divide(IOperator first, IOperator second) {
        super(first, second);
    }

    @Override
    public double evaluate(HashMap<Character, Double> dict) {
        try{
            return  (getFirst().evaluate(dict) / getSecond().evaluate(dict));
        } catch (Exception e){
            System.out.println("division by zero");
        }
        return 0;
    }
}
