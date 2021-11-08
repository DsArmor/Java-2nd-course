import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manipulation {
    public static void ex1(){
        String s = "";
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        Pattern pattern = Pattern.compile("^(?:31(/)(?:0?[13578]|1[02])\\1|(?:29|30)(/)(?:0?[1,3-9]|1[0-2])\\2)(?:1[9]|[2-9]\\d)?\\d{2}$"+
                "|^29(/)0?2\\3(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:16|[2468][048]|[3579][26])00)$"+
                "|^(?:0?[19]|1\\d|2[0-8])(/)(?:0?[1-9]|1[0-2])\\4(?:1[9]|[2-9]\\d)?\\d{2}$");
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.find());
    }

    public static void ex2(){
        String s = "";
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        Pattern pattern = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.find());
    }
    public static void main(String[] args) {
        ex1();
        ex2();
    }
}
