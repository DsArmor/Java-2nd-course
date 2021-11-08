package ex3.Operation;

import ex3.BinaryOperation;
import ex3.IOperator;

public class Divide extends BinaryOperation {

    public Divide(IOperator first, IOperator second) {
        super(first, second);
    }

    @Override
    public double evaluate(double a) {
        return (getFirst().evaluate(a) / getSecond().evaluate(a));
    }
}
