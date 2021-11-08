package ex2;

public class Test {
    public static void main(String[] args) {
        testLinkedQueue();
        testQueue();
    }

    public static void testLinkedQueue() {
        LinkedQueue link = new LinkedQueue();
        for (int i = 0; i < 11; i++) {
            link.enqueue(i);
        }
        link.print();
        System.out.print("\n");
        System.out.println(link.dequeue());
        link.print();
        System.out.print("\n");
        System.out.print(link.element() + "\n");
        System.out.println("Linked Queue size:" + link.size());
        System.out.println("Is linked queue empty? " + link.isEmpty());
        link.clear();
        System.out.println("Linked queue size:" + link.size());
        System.out.println("Is linked queue empty? " + link.isEmpty());
    }

    public static void testQueue() {
        ArrayQueue arr = new ArrayQueue();
        for (int i = 0; i < 11; i++) {
            arr.enqueue(i);
        }
        arr.print();
        System.out.print("\n");
        System.out.println(arr.dequeue());
        arr.print();
        System.out.print("\n");
        System.out.print(arr.element() + "\n");
        System.out.println("Queue size:" + arr.size());
        System.out.println("Is queue empty? " + arr.isEmpty());
        arr.clear();
        System.out.println("Queue size:" + arr.size());
        System.out.println("Is queue empty? " + arr.isEmpty());
    }
}

