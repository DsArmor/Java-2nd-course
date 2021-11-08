import java.io.*;
import java.util.Scanner;

public class Ex1_4 {
    public static void main(String[] args) {

        //ex1
        try {
            FileWriter writer = new FileWriter("D:\\third_semestr\\Java\\Git\\Java-2nd-course\\practice_23\\test.txt");
            writer.write(new Scanner(System.in).nextLine());
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //ex2
        try{
            FileReader reader = new FileReader("D:\\third_semestr\\Java\\Git\\Java-2nd-course\\practice_23\\test.txt");
            int c;
            while((c = reader.read()) != -1){
                System.out.print((char)c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //ex3
        try {
            FileWriter writer = new FileWriter("D:\\third_semestr\\Java\\Git\\Java-2nd-course\\practice_23\\test.txt", false);
            writer.write(new Scanner(System.in).nextLine());
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //ex4
        try {
            FileWriter writer = new FileWriter("D:\\third_semestr\\Java\\Git\\Java-2nd-course\\practice_23\\test.txt", true);
            writer.write(new Scanner(System.in).nextLine());
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
