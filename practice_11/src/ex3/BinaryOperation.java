package ex3;

public abstract class BinaryOperation implements IOperator{

    private IOperator first;
    private IOperator second;

    public BinaryOperation(IOperator first, IOperator second) {
        this.first = first;
        this.second = second;
    }

    public IOperator getFirst() {
        return first;
    }

    public IOperator getSecond() {
        return second;
    }
}
