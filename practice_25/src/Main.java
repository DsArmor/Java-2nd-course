import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static void containDir(String str){
        ArrayList<String> stringArrayList = new ArrayList<>();
        File dir = new File(str);
        if (dir.isDirectory()){
            for (File file : Objects.requireNonNull(dir.listFiles()))
            {
                if (file.isDirectory())
                    stringArrayList.add(file.getName() + " каталог");
                else
                    stringArrayList.add(file.getName() + " файл");
            }
        }
        if (stringArrayList.size() < 5)
        {
            for (String s : stringArrayList)
                System.out.println(s);
        } else
        {
            for (int i = 0; i < 5; i++)
                System.out.println(stringArrayList.get(i));
        }

    }

    private static ArrayList<String> convert(String[] strings){
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, strings);
        return arrayList;
    }

    public static void main(String[] args) {
        String[] strings = new String[(int)(Math.random()*20)];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < strings.length; i++){
            strings[i] = in.next();
        }
        System.out.println(convert(strings));

        containDir("D:\\");
    }
}
