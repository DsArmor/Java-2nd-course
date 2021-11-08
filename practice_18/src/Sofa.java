public class Sofa extends Furniture {
    public Sofa(String material, double width, double height, double length) {
        super(material, width, height, length);
    }

    @Override
    public void getName() {
        System.out.println("This if sofa");
    }
}
