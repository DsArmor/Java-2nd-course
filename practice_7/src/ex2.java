import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();

        for (int i = 0; i < 5; i++) {
            queue1.add(in.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            queue2.add(in.nextInt());
        }
        int count = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int first = queue1.poll();
            int second = queue2.poll();

            count++;
            if (count == 106) {
                System.out.println("botva");
                System.exit(0);
            }

            if (first > second && !(first == 9 && second == 0)) {
                queue1.add(first);
                queue1.add(second);
            } else {
                queue2.add(first);
                queue2.add(second);
            }
        }
        if (!queue1.isEmpty())
            System.out.println("first " + count);
        else
            System.out.println("second " + count);

    }
}
