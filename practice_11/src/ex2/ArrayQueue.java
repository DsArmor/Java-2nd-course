package ex2;

public class ArrayQueue extends AbstractQueue {
    private final int START_CAPACITY = 16;
    private int front;
    private int rear;
    private Object[] array;

    public ArrayQueue() {
        array = new Object[START_CAPACITY];
        size = 0;
        front = 0;
        rear = 0;
    }

    private void checkSize(int capacity) {
        if (capacity >= array.length) {
            Object[] temp = new Object[capacity];
            int count = rear < front ? array.length - front : size;
            System.arraycopy(array, front, temp, 0, count);
            if (rear < front)
                System.arraycopy(array, 0, temp, count, rear);
            array = temp;
            front = 0;
            rear = size;
        }
    }

    public void enqueue(Object element) {
        if (element != null) {
            checkSize(size + 1);
            array[rear] = element;
            rear = (rear + 1) % array.length;
            size++;
        }
    }

    public Object element() {
        if (size > 0) {
            return array[front];
        }
        return null;
    }

    public Object dequeue() {
        if (size > 0) {
            Object answer = element();
            array[front] = null;
            front = (front + 1) % array.length;
            size--;
            return answer;
        }
        return null;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if (array[i] != null)
                System.out.print(array[i] + " ");
        }
    }
}

