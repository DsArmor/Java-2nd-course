public class Pot extends Dish {
    private double hardness;
    private double thickness;
    Pot(String material, double hardness, double thickness) {
        super(material);
        this.hardness = hardness;
        this.thickness = thickness;
    }

    @Override
    public void printInfo() {
        System.out.println("Pot`s material is "+this.material+", it`s hardness is "+this.hardness+", it`s thickness is "+this.thickness);
    }
}
