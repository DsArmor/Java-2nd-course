import java.util.LinkedList;
import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();

        for (int i = 0; i < 5; i++) {
            list1.addLast(in.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            list2.addLast(in.nextInt());
        }
        int count = 0;
        while (!list1.isEmpty() && !list2.isEmpty()) {
            int first = list1.pollFirst();
            int second = list2.pollFirst();

            count += 1;
            if (count == 106) {
                System.out.println("botva");
                System.exit(0);
            }

            if (first > second && !(first == 9 && second == 0)) {
                list1.addLast(first);
                list1.addLast(second);
            } else {
                list2.addLast(first);
                list2.addLast(second);
            }
        }
        if (!list1.isEmpty())
            System.out.println("first " + count);
        else
            System.out.println("second " + count);

    }
}
