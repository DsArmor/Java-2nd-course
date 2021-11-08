import java.util.Scanner;

public class ex12 {
    public static void printOdd() {
        Scanner in = new Scanner(System.in);
        int current = in.nextInt();
        if (current == 0) {
            return;
        } else
        {
            if (current % 2 != 0)
                System.out.println(current);
            printOdd();
        }
    }

    public static void main(String[] args) {
        printOdd();
    }
}
