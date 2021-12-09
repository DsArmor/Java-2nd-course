package ex1;

public class Test {
    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory();
        Complex complex1 = factory.createComplex();
        Complex complex2 = factory.createComplex(4, 32);
        System.out.println(complex1);
        System.out.println(complex2);
    }
}
