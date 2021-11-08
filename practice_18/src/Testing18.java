public class Testing18 {
    public static void testDish(){
        Bowl bowl = new Bowl("iron",25,25);
        Pot pot = new Pot("aluminum",25,25);
        Dish pott = new Pot("steel",10,10);
        bowl.printInfo();
        pot.printInfo();
        pott.printInfo();
    }
    public static void testDog(){
        Akita akita = new Akita("white",5);
        GermanShepherd shepherd = new GermanShepherd("brown",9);
        ToyTerrier toyTerrier = new ToyTerrier("light-brown",3);
        akita.toBark();
        shepherd.toBark();
        toyTerrier.toBark();
    }
    public static void main(String[] args) {
    testDish();
    testDog();
    FurnitureShop.test();
    }
}
