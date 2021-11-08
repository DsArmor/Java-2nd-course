import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        BoundedWaitList<Integer> bound = new BoundedWaitList<Integer>(10);
        System.out.println("Тест BoundedWaitList");
        for (int i = 0; i < 11; i++){
            bound.add(i);
        }
        System.out.println("Cписок: "+bound.toString());
        System.out.println("Размер списка: "+ bound.getCapacity());
        System.out.println("Тест UnfairWaitList");
        UnfairWaitList<Integer> unfair = new UnfairWaitList<Integer>();
        for (int i = 0; i < 11; i++){
            unfair.add(i);
        }
        System.out.println(unfair.containsAll(new ArrayList<Integer>(Arrays.asList(1,2,3,4))));
        System.out.println("Cписок: "+unfair.toString());
        unfair.moveToBack(5);
        unfair.remove(6);
        System.out.println("Cписок: "+unfair.toString());
        System.out.println(unfair.contains(2));
    }
}