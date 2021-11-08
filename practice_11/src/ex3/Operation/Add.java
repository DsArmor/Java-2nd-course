package ex3.Operation;

import ex3.BinaryOperation;
import ex3.IOperator;

public class Add extends BinaryOperation {

    public Add(IOperator first, IOperator second) {
        super(first, second);
    }

    @Override
    public double evaluate(double a) {
        return (getFirst().evaluate(a) + getSecond().evaluate(a));
    }
}
