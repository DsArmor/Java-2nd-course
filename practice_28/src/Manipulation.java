import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manipulation {
    public static void ex1(){
        String s = "";
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            s += in.nextLine();
        }
        Pattern pattern = Pattern.compile("\\d+(\\.?\\d+ (USD|RUB|EU)| (USD|RUB|EU))");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            System.out.println(matcher.group()+" ");
        }
//        24.8 USD;
//        35 EU;
//        57.2 USD;
//        24 UDS, 25USD, 4839 ET, 89 RUB, 67 RuB;
//         EU RUB      USD 3 USD
    }

    public static void ex2(){
        String s = "";
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            s += in.nextLine();
        }
        Pattern pattern = Pattern.compile("\\d+[^\\d*\\s*+]|\\d+$");
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.find());
        //1 + 2 +
    }


    public static void main(String[] args) {
//        ex1();
        ex2();
    }
}
