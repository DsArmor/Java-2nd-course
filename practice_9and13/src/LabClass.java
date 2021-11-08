import java.util.ArrayList;
import java.util.Comparator;

public class LabClass implements Comparator<Student> {

    ArrayList<Student> students;

    public LabClass(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean find(String name) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.getName().equals(name))
                return true;
        }
        throw new StudentNotFoundException(name);
    }

    public void sortByGPA() {
        quickSort(students, 0, students.size() - 1);
    }

    private void quickSort(ArrayList<Student> students, int low, int high) {
        if (students.size() == 0)
            return;
        if (low >= high)
            return;

        int middle = (low + high) / 2;
        Student opora = students.get(middle);

        int i = low, j = high;
        while (i <= j) {
            while (compare(opora, students.get(i)) > 0) {
                i++;
            }
            while (compare(opora, students.get(j)) < 0) {
                j--;
            }
            if (i <= j) {
                swap(students.get(i), students.get(j));
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(students, low, j);
        if (high > i)
            quickSort(students, i, high);
    }

    private void swap(Student a, Student b) {
        Student temp;
        temp = new Student(a.getName(), a.getId(), a.getGPA());
        a.setName(b.getName());
        a.setId(b.getId());
        a.setGPA(b.getGPA());
        b.setName(temp.getName());
        b.setId(temp.getId());
        b.setGPA(temp.getGPA());
    }

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o2.getGPA(), o1.getGPA());
    }

    @Override
    public String toString() {
        return "SortingStudentByGPA{" +
                "students=" + students +
                '}';
    }
}
