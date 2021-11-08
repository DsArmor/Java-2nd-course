package ex3;

public class Variable implements IOperator{

    private final String name;
    private double value;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(double a) {
        this.value = a;
        return (this.value);
    }
}
