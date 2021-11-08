import java.util.Scanner;

public class ex11 {

    public static int numberOne(Scanner in, boolean check, int count) {
        int current = in.nextInt();
        if (current == 0 && check) {
            return count;
        }
        check = current == 0;
        if (current == 1)
            count += 1;
        count = numberOne(in, check, count);
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        count = numberOne(in, false, count);
        System.out.println(count);
    }
}
