public class Chair extends Furniture {
    public Chair(String material, double width, double height, double length) {
        super(material, width, height, length);
    }

    @Override
    public void getName() {
        System.out.println("This is chair");
    }
}
