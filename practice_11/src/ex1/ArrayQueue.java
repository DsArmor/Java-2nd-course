package ex1;

public class ArrayQueue {
    private  final int START_CAPACITY = 16;
    private int size;
    private int front;
    private int rear;
    private Object[] array;
    //PRE:array null
    //POST:arr.length = 10; size = front = rear = 0
    public ArrayQueue(){
        array = new Object[START_CAPACITY];
        size = 0;
        front = 0;
        rear = 0;
    }
    //PRE: none
    //POST: arr.length = size, front = 0, rear = size
    private  void checkSize(int capacity){
        if (capacity >= array.length){
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
    //PRE:element not null
    //POST: array[rear] = element; rear = (rear+1) % array.length; size = size + 1;
    public  void enqueue(Object element){
        if (element != null){
            checkSize(size+1);
            array[rear] = element;
            rear = (rear + 1) % array.length;
            size++;
        }
    }
    //PRE: size > 0
    //POST: returns front element or null if size == 0
    public  Object element(){
        if (size > 0){
            return array[front];
        }
        return null;
    }
    //PRE: size>0
    //POST: returns front element or null if size == 0
    public  Object dequeue(){
        if (size > 0){
            Object answer = element();
            array[front] = null;
            front = (front + 1)% array.length;
            size--;
            return answer;
        }
        return null;
    }
    //PRE:none
    //POST: returns size
    public  int size(){
        return size;
    }
    //PRE:none
    //POST: returns (size == 0)
    public  boolean isEmpty(){
        return (size == 0);
    }
    // PRE:none
    // POST:size = 0, arr.length = 10, front = 0, rear = 0
    public  void clear(){
        size = 0;
        front = 0;
        rear = 0;
        array = new Object[START_CAPACITY];
    }
    //PRE:none
    //POST: print all queue values
    public  void print(){
        for (int i = 0;i<size;i++){
            if (array[i]!=null)
                System.out.print(array[i]+" ");
        }
    }
}
