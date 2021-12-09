package INN;

public class WrongInnException extends Exception {
    private long inn;
    private String surname;
    public WrongInnException(long inn, String surname){
        super("ИНН гражданина " +surname+": "+inn+" не действителен");
        this.surname = surname;
        this.inn = inn;
    }
}

