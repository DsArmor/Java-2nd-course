import java.util.concurrent.ConcurrentLinkedQueue;

public class BoundedWaitList<E> extends WaitList<E>{
    private int capacity;

    public BoundedWaitList(int capacity) {
        super();
        this.capacity = capacity;
    }

    /**
     * @return вместимость списка
     */

    public int getCapacity() {
        return capacity;
    }

    /**
     * добавление элемента к списку, если позволяет вместимость
     * @param element добавляемый элемент
     */

    @Override
    public void add(E element) {
        if (content.size() == capacity)
        {
            System.out.println("No vacancies");
        } else
            super.add(element);
    }

    @Override
    public String toString() {
        return "BoundedWaitList{" +
                "capacity=" + capacity +
                ", content=" + content +
                '}';
    }
}
