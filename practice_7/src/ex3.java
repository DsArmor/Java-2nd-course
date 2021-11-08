import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> queue1 = new LinkedList<Integer>();
        Deque<Integer> queue2 = new LinkedList<Integer>();

        for (int i = 0; i < 5; i++) {
            queue1.addLast(in.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            queue2.addLast(in.nextInt());
        }
        int count = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int first = queue1.pop();
            int second = queue2.pop();

            count++;
            if (count == 106) {
                System.out.println("botva");
                System.exit(0);
            }

            if (first > second && !(first == 9 && second == 0)) {
                queue1.addLast(first);
                queue1.addLast(second);
            } else {
                queue2.addLast(first);
                queue2.addLast(second);
            }
        }
        if (!queue1.isEmpty())
            System.out.println("first " + count);
        else
            System.out.println("second " + count);

    }
}
