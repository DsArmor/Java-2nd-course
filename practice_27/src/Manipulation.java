import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manipulation {

    private static void menu(){
        System.out.println("Меню");
        System.out.println("1 - поиск полного совпадения");
        System.out.println("2 - поиск шаблона в начале");
        System.out.println("3 - поиск шаблона в конце");
        System.out.println("4 - разбить строку на слова");
        System.out.println("5 - выход");
    }

    public static void ex1(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку и шаблон");
        String s = in.nextLine();
        String reg = in.nextLine();
        Pattern pattern = Pattern.compile(reg);
        while (true){
            menu();
            Matcher matcher = pattern.matcher(s);
            switch (in.nextInt()){
                case 1:
                    while (matcher.find())
                        System.out.println(matcher.start() + " " + matcher.group());
                    break;
                case 2:
                    if (matcher.find())
                        System.out.println("Индекс начала шаблона " + matcher.start());
                    break;
                case 3:
                    int temp = -1;
                    while (matcher.find()){
                        temp = matcher.start();
                    }
                    System.out.println(temp);
                    break;
                case 4:
                    Pattern pattern1 = Pattern.compile("\\s*(\\s|,|!|\\.)\\s*");
                    String[] words = pattern1.split(s);
                    for (String word : words)
                        System.out.println(word);
                    break;
                case 5:
                    return ;
            }
        }
    }

    public static void main(String[] args) {
//        ex1();
        Pattern p = Pattern.compile("^abcdefghijklmnopqrstuv18340$");
        System.out.println(p.matcher(new Scanner(System.in).nextLine()).find());
    }
}
