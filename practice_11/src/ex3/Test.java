package ex3;

import ex3.Const;
import ex3.IOperator;
import ex3.Operation.Add;
import ex3.Operation.Multiply;
import ex3.Operation.Subtract;
import ex3.Variable;

public class Test {
    public static void main(String[] args) {
        double result;
        result = new Subtract(
                new Multiply(
                        new Const(2),
                        new Variable("x")
                ),
                new Const(3)
        ).evaluate(5);
        System.out.println(result);
        IOperator expression = new Add(
                new Subtract(
                        new Multiply(
                                new Variable("x"),
                                new Variable("x")
                        ),
                        new Multiply(
                                new Const(2),
                                new Variable("x")
                        )
                ),
                new Const(1)
        );
        System.out.println(expression.evaluate(8));
        System.out.println(expression.evaluate(1));
        System.out.println(expression.evaluate(2));
    }
}
