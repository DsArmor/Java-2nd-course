import java.util.Locale;
import java.util.Scanner;

class Main {

    public static String getLine(String fileName) {
        String[] strings = fileName.split(" ");
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].substring(strings[i].length() - 1).equalsIgnoreCase(strings[j].substring(0, 1))) {
                    String temp = strings[i + 1];
                    strings[i + 1] = strings[j];
                    strings[j] = temp;
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }
        return String.valueOf(stringBuilder);
    }

    public static void main(String[] args) {
        //ex2
        System.out.println(new Address("Russia? Moscow obl? Moscow? Perv? 11"));
//        System.out.println(new Address("USA; Khalifa obl; Ottawa; Norte; 13", ";"));
//        System.out.println(new Address("France, Paris obl, Paris, Kochab, 21"));
//        System.out.println(new Address("Bulgaria, Sofas, Sofia, Ost, 1"));

        //ex3
        String[] shirts = new String[11];
        shirts[0] = "S001?Black Polo Shirt?Black?XL";
        shirts[1] = "S002,Black Polo Shirt,Black,L";
        shirts[2] = "S003,Blue Polo Shirt,Blue,XL";
        shirts[3] = "S004,Blue Polo Shirt,Blue,M";
        shirts[4] = "S005,Tan Polo Shirt,Tan,XL";
        shirts[5] = "S006,Black T-Shirt,Black,XL";
        shirts[6] = "S007,White TShirt,White,XL";
        shirts[7] = "S008,White T-Shirt,White,L";
        shirts[8] = "S009,Green T-Shirt,Green,S";
        shirts[9] = "S010,Orange T-Shirt,Orange,S";
        shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";
        Shirt[] shirts1 = new Shirt[11];
        for (int i = 0; i < shirts1.length; i++) {
            shirts1[i] = new Shirt(shirts[i]);
        }
        for (Shirt shirt : shirts1) {
            System.out.println(shirt);
        }

        //ex4
        PhoneNumber phoneNumber = new PhoneNumber("+79175655655");
        System.out.println(phoneNumber.getPhone());
        phoneNumber = new PhoneNumber("+104289652211");
        System.out.println(phoneNumber.getPhone());
        phoneNumber = new PhoneNumber("89175655655");
        System.out.println(phoneNumber.getPhone());

        //ex5
        Scanner in = new Scanner(System.in);
        System.out.println(getLine(in.nextLine()));
    }
}
