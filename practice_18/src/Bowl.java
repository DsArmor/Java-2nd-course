public class Bowl extends Dish {
    private double depth;
    private double radius;
    Bowl(String material, double depth, double radius) {
        super(material);
        this.depth = depth;
        this.radius = radius;
    }

    @Override
    public void printInfo() {
        System.out.println("Bowl material is "+this.material+", depth is "+this.depth+", radius is "+this.radius);
    }
}
