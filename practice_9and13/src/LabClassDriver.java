import java.util.ArrayList;

public class LabClassDriver {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Петров", 1, 25));
        students.add(new Student("Иванов", 2, 15));
        students.add(new Student("Сидоров", 3, 47));
        students.add(new Student("Майланбек", 4, 100));
        students.add(new Student("Желехнов", 5, 31));
        students.add(new Student("Качкин", 6, 49));
        new LabClassUI(new LabClass(students));
    }
}
