public abstract class Furniture {
    private String material;
    private double width;
    private double height;
    private double length;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Furniture(String material, double width, double height, double length) {

        this.material = material;
        this.width = width;
        this.height = height;
        this.length = length;
    }
    public abstract void getName();

}
