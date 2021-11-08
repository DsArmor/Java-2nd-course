import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitList<E> implements IWaitList<E>{

    protected ConcurrentLinkedQueue<E> content;

    public WaitList() {
        this.content = new ConcurrentLinkedQueue<>();
    }

    public WaitList(ConcurrentLinkedQueue<E> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "WaitList{" +
                "content=" + content +
                '}';
    }

    /**
     * добавляет элемент в список
     * @param element добавляемый элемент
     */

    @Override
    public void add(E element) {
        content.add(element);
    }

    /**
     * удаляет последний элемент из списка
     * @return возвращает удаляемый элемент
     */

    @Override
    public E remove() {
        return content.remove();
    }

    /**
     * проверяет содержет ли список такой элемент
     * @param element эталон проверки
     * @return результат проверки true - если найдено, false - в противном случае
     */

    @Override
    public boolean contains(E element) {
        return content.contains(element);
    }

    /**
     * проверяет есть ли все элементы коллекции в списке
     * @param c эталонная коллекция
     * @return результат проверки true - если найдены все элементы, false - в противном случае
     */

    @Override
    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }

    /**
     * проверяет на пустоту список
     * @return результат проверки true - если список пустой, false - в противном случае
     */

    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }
}
