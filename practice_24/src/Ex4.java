import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner( System.in );
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (Exception e){
            System.out.println("nrl");
        } finally {
            System.out.println("Norm");
        }
    }
}