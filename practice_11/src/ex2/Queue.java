package ex2;

public interface Queue {
    void enqueue(Object element);

    //Pre: size > 0
    //Post: return queue[0]
    Object element();

    //Invariant: size = size - 1
    //Pre: size > 0
    //Post: return queue[0], queue.length = queue.length - 1
    Object dequeue();

    //Post: return queue`s size
    int size();

    //Post: return (size == 0)
    boolean isEmpty();

    //Invariant: size = 0;
    //Post: clear the queue
    void clear();

    //Post:print the queue
    void print();
}
