import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner( System.in );
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (Exception e){
            System.out.println("nrl");
        }
//        catch (NumberFormatException e){
//            System.out.println("Вы ввели некорректное значение");
//        } catch (ArithmeticException e){
//            System.out.println("Division by zero");
//        }
    }
}
