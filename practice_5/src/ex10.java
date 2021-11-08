import java.util.Scanner;

public class ex10 {
    public static int pow(int x){
        int p = 1;
        if (x > 99)
        {
            p*=pow(x/10);
        }
        return (p * 10);
    }

    public static int reverse(int x, int p){
        int result = 0;
        if (x > 9)
            result += x % 10 * p + reverse(x /10, p/10);
        else
            return x;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        System.out.println(reverse(x, pow(x)));
    }
}
