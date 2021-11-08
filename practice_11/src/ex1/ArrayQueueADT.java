package ex1;

public class ArrayQueueADT {
    private static final int START_CAPACITY = 16;
    private int size;
    private int front;
    private int rear;
    private Object[] array;

    //PRE:array null
    //POST:arr.length = 10; size = front = rear = 0
    public ArrayQueueADT() {
        array = new Object[START_CAPACITY];
        size = 0;
        front = 0;
        rear = 0;
    }

    //PRE: adt not null
    //POST: arr.length = size, front = 0, rear = size
    private static void checkSize(ArrayQueueADT adt, int capacity) {
        if (capacity >= adt.array.length) {
            Object[] temp = new Object[capacity];
            int count = adt.rear < adt.front ? adt.array.length - adt.front : adt.size;
            System.arraycopy(adt.array, adt.front, temp, 0, count);
            if (adt.rear < adt.front)
                System.arraycopy(adt.array, 0, temp, count, adt.rear);
            adt.array = temp;
            adt.front = 0;
            adt.rear = adt.size;
        }
    }

    //PRE:adt not null, element not null
    //POST: adt.array[adt.rear] = element; adt.rear = (adt.rear+1) % adt.array.length; adt.size = adt.size + 1;
    public static void enqueue(ArrayQueueADT adt, Object element) {
        if (element != null) {
            checkSize(adt, adt.size + 1);
            adt.array[adt.rear] = element;
            adt.rear = (adt.rear + 1) % adt.array.length;
            adt.size++;
        }
    }

    //PRE: size > 0 adt not null
    //POST: returns front element or null if size == 0
    public static Object element(ArrayQueueADT adt) {
        if (adt.size > 0) {
            return adt.array[adt.front];
        }
        return null;
    }

    //PRE: size>0 adt not null
    //POST: returns front element or null if size == 0
    public static Object dequeue(ArrayQueueADT adt) {
        if (adt.size > 0) {
            Object answer = element(adt);
            adt.array[adt.front] = null;
            adt.front = (adt.front + 1) % adt.array.length;
            adt.size--;
            return answer;
        }
        return null;
    }

    //PRE:adt not null
    //POST: returns size
    public static int size(ArrayQueueADT adt) {
        return adt.size;
    }

    //PRE:adt not null
    //POST: returns (size == 0)
    public static boolean isEmpty(ArrayQueueADT adt) {
        if (adt != null)
            return (adt.size == 0);
        return false;
    }

    // PRE:adt not null
    // POST:size = 0, arr.length = 10, front = 0, rear = 0
    public static void clear(ArrayQueueADT adt) {
        if (adt != null) {
            adt.size = 0;
            adt.front = 0;
            adt.rear = 0;
            adt.array = new Object[START_CAPACITY];
        }
    }

    //PRE:adt not null
    //POST: print all queue values
    public static void print(ArrayQueueADT adt) {
        for (int i = 0; i < adt.size; i++) {
            if (adt.array[i] != null)
                System.out.print(adt.array[i] + " ");
        }
    }
}
