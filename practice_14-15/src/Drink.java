public class Drink implements Item {

    private static final double ZERO = 0.0;

    private final double price;
    private final String name;
    private final String description;

    public Drink(String name, String description) {
        this.price = ZERO;
        this.name = name;
        this.description = description;
    }

    public Drink(double price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
