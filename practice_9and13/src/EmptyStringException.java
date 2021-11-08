public class EmptyStringException extends IllegalArgumentException{
    public EmptyStringException() {
        super("Вы ничего не ввели");
    }
}
