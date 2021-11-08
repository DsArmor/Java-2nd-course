package ex2;

public class LinkedQueue extends AbstractQueue {
    private Node front;
    private Node rear;

    private static class Node {
        Node next;
        Node prev;
        Object value;

        Node(Node next, Node prev, Object value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }

    @Override
    public void enqueue(Object element) {
        Node temp = new Node(null, rear, element);
        if (front == null) {
            front = temp;
            rear = temp;
        } else {
            rear.next = temp;
            rear = rear.next;
        }
        size++;
    }

    @Override
    public Object element() {
        if (front != null)
            return front.value;
        return null;
    }

    @Override
    public Object dequeue() {
        // If queue is empty, return NULL.
        if (this.front == null)
            return null;

        // Store previous front and move front one node ahead
        Node temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
        size--;
        return temp.value;
    }

    @Override
    public void print() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
}
