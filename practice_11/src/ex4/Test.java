package ex4;

import ex4.Const;
import ex4.IOperator;
import ex4.Operation.Add;
import ex4.Operation.Multiply;
import ex4.Operation.Subtract;
import ex4.Variable;

import java.util.HashMap;

public class Test {
    public static void main(String[] args)
    {
        HashMap<Character, Double> dict = new HashMap<>();
        dict.put('x', 5.0);
        dict.put('y', 4.0);
        dict.put('z', 2.0);
        ExpressionParser expressionParser = new ExpressionParser(dict);

        System.out.println(expressionParser.tripleExpressionParse("x * (y - 2)*z + 1").evaluate(dict));
//        System.out.println("x         f");
        for (int i = 0; i < 11; i++){
            dict.put('x', Double.parseDouble(String.valueOf(i)));
//            System.out.println(dict.get('x') + "     " + expressionParser.tripleExpressionParse("1000000*x*x*x*x*x/(x-1)").evaluate(dict));
        }
    }
}
