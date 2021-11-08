public class Testing19 {
    public static void main(String[] args) {
        Nameable name1 = new Name1();
        Nameable name2 = new Name2();
        Priceable price1 = new Price1();
        Priceable price2 = new Price2();
        System.out.println(name1.getName());
        System.out.println(name2.getName());
        System.out.println(price1.getPrice());
        System.out.println(price2.getPrice());
    }
}
