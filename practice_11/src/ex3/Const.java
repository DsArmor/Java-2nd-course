package ex3;

public class Const implements IOperator{

    double value;

    public Const(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(double a) {
        return value;
    }
}
