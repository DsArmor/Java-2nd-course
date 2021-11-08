package ex4;

import ex4.Operation.Add;
import ex4.Operation.Divide;
import ex4.Operation.Multiply;
import ex4.Operation.Subtract;

import java.util.HashMap;
import java.util.Stack;

public class ExpressionParser {

    HashMap<Character, Double> dict;

    public ExpressionParser(HashMap<Character, Double> dict) {
        this.dict = dict;
    }

    private boolean isAl(Character character) {
        return character == 'x' || character == 'y' || character == 'z';
    }

    private boolean isDigit(Character character) {
        return character >= '0' && character <= '9';
    }

    private boolean isOperation(Character character) {
        return character == '+' || character == '-' || character == '*' || character == '/';
    }

    private int priorityOperation(Character character) {
        return
                character == '+' || character == '-' ? 1 :
                        character == '*' || character == '/' ? 2 : -1;
    }

    private void doIt(Stack<IOperator> numbers, Character operation) {
        IOperator second = numbers.pop();
        IOperator first = numbers.pop();

        try {
            switch (operation) {
                case '+' -> numbers.add(new Const(new Add(first, second).evaluate(dict)));
                case '-' -> numbers.add(new Const(new Subtract(first, second).evaluate(dict)));
                case '/' -> numbers.add(new Const(new Divide(first, second).evaluate(dict)));
                case '*' -> numbers.add(new Const(new Multiply(first, second).evaluate(dict)));
            }
        } catch (ArithmeticException ae) {
            System.out.println("overflow");
        }
    }

    public IOperator tripleExpressionParse(String str) {
        Stack<IOperator> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        boolean last = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (str.charAt(i) == '('){
                    operations.push('(');
                    last = true;
                }
                else if (str.charAt(i) == ')') {
                    while (operations.peek() != '(')
                        doIt(numbers, operations.pop());
                    operations.pop();
                    last = false;
                } else if (isOperation(str.charAt(i))) {
//                    if (str.charAt(i) == '-' && last)
//                    {
//                        numbers.add(new Const(new Subtract(numbers.pop(), new Const(-1.0)).evaluate(dict)));
//                        operations.pop();
//                    }
                    while (!operations.isEmpty() && priorityOperation(operations.peek()) >= priorityOperation(str.charAt(i))) {
                        doIt(numbers, operations.pop());
                    }
                    last = true;
                    operations.push(str.charAt(i));
                } else {
                    last = false;
                    String strNumber = "";
                    if (isAl(str.charAt(i))) {
                        numbers.push(new Variable(str.charAt(i)));
                        continue;
                    }
                    while (i < str.length() && isDigit(str.charAt(i)))
                        strNumber += str.charAt(i++);
                    --i;
                    numbers.push(new Const(Integer.parseInt(strNumber)));
                }
            }
        }
        while (!operations.isEmpty())
            doIt(numbers, operations.pop());
        return numbers.pop();
    }
}
