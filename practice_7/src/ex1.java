import java.util.Scanner;
import java.util.Stack;

public class ex1 {

    public static Stack<Integer> reverseStack(Stack<Integer> stack) {
        Stack<Integer> revStack = new Stack<>();
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            revStack.push(stack.pop());
        }
        return (revStack);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < 5; i++) {
            stack1.push(in.nextInt());
        }
        stack1 = reverseStack(stack1);
        for (int i = 0; i < 5; i++) {
            stack2.push(in.nextInt());
        }

        stack2 = reverseStack(stack2);
        int count = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Integer first = stack1.pop();
            Integer second = stack2.pop();
            count++;
            if (count == 106) {
                System.out.println("botva");
                System.exit(0);
            }
            if (first > second && !(first == 9 && second == 0)) {
                stack1 = reverseStack(stack1);
                stack1.push(first);
                stack1.push(second);
                stack1 = reverseStack(stack1);
            } else {
                stack2 = reverseStack(stack2);
                stack2.push(first);
                stack2.push(second);
                stack2 = reverseStack(stack2);
            }
        }
        if (!stack1.isEmpty())
            System.out.println("first " + count);
        else
            System.out.println("second " + count);

    }
}
