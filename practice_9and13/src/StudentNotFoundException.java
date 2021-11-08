public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String name)
    {
        super("Студента " + name + " нет");
    }
}
