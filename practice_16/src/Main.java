import java.util.Random;

public class Main {

    private static long factorial(int f){
        long res = 1;
        for (int i = 2; i < f; i++)
        {
            res*=i;
        }
        return res;
    }


    public static void main(String[] args) {

        //ex1
        final Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(100);
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        System.out.println(sum);
        sum = 0;
        int i = 0;
        while(i < array.length){
            sum+=array[i];
            i++;
        }
        System.out.println(sum);
        sum = 0;
        i =0;
        do{
            sum+=array[i];
            i++;
        } while (i < array.length);
        System.out.println(sum);

        //ex2
        for (int j = 0; j < args.length; j++){
            System.out.println(args[i]);
        }

        //ex3
        double g = 1.0;
        for (int j = 0; j < 10; j++)
            System.out.println(g/=2);


        //ex4
        int[] array1 = new int[10];
        for (int j = 0; j < 10; j++) {
            array1[j] = random.nextInt(100);
        }
        for (int j = 0; j < 10; j++) {
            System.out.println(array1[j]);        }
        for (int j = 0; j < 10; j++)
        {
            for (int k = j + 1; k < 10; k++){
                if (array1[j] > array1[k])
                {
                    int temp = array1[j];
                    array1[j] = array1[k];
                    array1[k] = temp;
                }
            }
        }

        //ex5
        System.out.println(factorial(4));
    }
}
