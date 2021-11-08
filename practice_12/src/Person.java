public class Person {

    StringBuffer name;
    StringBuffer surname;
    StringBuffer middleName;

    public Person(String name, String surname, String middleName) {
        this.name = new StringBuffer(name);
        this.surname = new StringBuffer(surname);
        this.middleName = new StringBuffer(middleName);
    }

    public String getFIO() {
        return String.valueOf(name.append(surname).append(middleName));
    }
}
