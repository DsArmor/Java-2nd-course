import java.util.Arrays;
import java.util.Scanner;

public class ex1 {

    public static void swap(Student a, Student b) {
        Student temp;
        temp = new Student(a.getName(), a.getId());
        a.setName(b.getName());
        a.setId(b.getId());
        b.setName(temp.getName());
        b.setId(temp.getId());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Student[] students = new Student[in.nextInt()];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(in.next(), in.nextInt());
        }
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getId() > students[j].getId()) {
                    swap(students[i], students[j]);
                }
            }
        }
        System.out.println(Arrays.toString(students));
    }
}
