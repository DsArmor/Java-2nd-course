import java.util.ArrayList;
import java.util.Scanner;

public class ex3 {

    public static ArrayList<Student> mergeArray(ArrayList<Student> arrayA, ArrayList<Student> arrayB) {

        ArrayList<Student> arrayC = new ArrayList<>();
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayA.size() + arrayB.size(); i++) {
            if (positionA == arrayA.size()) {
                arrayC.add(arrayB.get(positionB));
                positionB++;
            } else if (positionB == arrayB.size()) {
                arrayC.add(arrayA.get(positionA));
                positionA++;
            } else if (arrayA.get(positionA).getGPA() < arrayB.get(positionB).getGPA()) {
                arrayC.add(arrayA.get(positionA));
                positionA++;
            } else {
                arrayC.add(arrayB.get(positionB));
                positionB++;
            }
        }
        return arrayC;
    }

    public static ArrayList<Student> sortArray(ArrayList<Student> arrayA) {
        if (arrayA == null) {
            return null;
        }
        if (arrayA.size() < 2) {
            return arrayA;
        }
        ArrayList<Student> arrayB = new ArrayList<>(arrayA.subList(0, arrayA.size() / 2));

        ArrayList<Student> arrayC = new ArrayList<>(arrayA.subList(arrayA.size() / 2, arrayA.size()));

        arrayB = sortArray(arrayB);
        arrayC = sortArray(arrayC);

        return mergeArray(arrayB, arrayC);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<Student> students1;
        students1 = new ArrayList<>();

        ArrayList<Student> students2;
        students2 = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            students1.add(new Student(in.next(), in.nextInt(), in.nextInt()));
        }

        for (int i = 0; i < 5; i++) {
            students2.add(new Student(in.next(), in.nextInt(), in.nextInt()));
        }

        students1.addAll(students2);
        System.out.println(sortArray(students1));

    }
}
