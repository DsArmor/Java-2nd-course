package ex1;

public class Test {
    public static void main(String[] args) {
        System.out.println("QueueModule ex1.Test");
        testQueueModule();
        System.out.println("QueueADT ex1.Test");
        testADT();
        System.out.println("Queue ex1.Test");
        testQueue();
    }

    public static void testQueueModule() {
        new ArrayQueueModule();
        for (int i = 0; i < 11; i++) {
            ArrayQueueModule.enqueue(i);
        }
        ArrayQueueModule.print();
        System.out.print("\n");
        System.out.println(ArrayQueueModule.dequeue());
        ArrayQueueModule.print();
        System.out.print("\n");
        System.out.print(ArrayQueueModule.element() + "\n");
        System.out.println("Queue size:" + ArrayQueueModule.size());
        System.out.println("Is queue empty? " + ArrayQueueModule.isEmpty());
        ArrayQueueModule.clear();
        System.out.println("Queue size:" + ArrayQueueModule.size());
        System.out.println("Is queue empty? " + ArrayQueueModule.isEmpty());
    }

    public static void testADT() {
        ArrayQueueADT adt = new ArrayQueueADT();
        for (int i = 0; i < 11; i++) {
            ArrayQueueADT.enqueue(adt, i);
        }
        ArrayQueueADT.print(adt);
        System.out.print("\n");
        System.out.println(ArrayQueueADT.dequeue(adt));
        ArrayQueueADT.print(adt);
        System.out.print("\n");
        System.out.print(ArrayQueueADT.element(adt) + "\n");
        System.out.println("Queue size:" + ArrayQueueADT.size(adt));
        System.out.println("Is queue empty? " + ArrayQueueADT.isEmpty(adt));
        ArrayQueueADT.clear(adt);
        System.out.println("Queue size:" + ArrayQueueADT.size(adt));
        System.out.println("Is queue empty? " + ArrayQueueADT.isEmpty(adt));
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
