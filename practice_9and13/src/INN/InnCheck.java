package INN;
import java.util.Scanner;

public class InnCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Введите Фамилию и ИНН");
            String surname = scanner.next();
            try{

                long inn = scanner.nextLong();
                checkInn(inn,surname);

            }catch(WrongInnException e){
                System.out.println(e.getMessage());
                break;
            }
            System.out.println("ИНН гражданина "+surname+" действителен");
        }

    }
    public static boolean checkInn(long inn,String surname) throws  WrongInnException{
        if (inn>=1000000 && inn<1000000000){
            return true;
        }
        throw new WrongInnException(inn,surname);
    }
}

