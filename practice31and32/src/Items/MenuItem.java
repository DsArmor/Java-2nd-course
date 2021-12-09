package Items;

public class MenuItem {
    private final int cost;
    private final String name;
    private final String description;

    public MenuItem(int cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }
    public int getCost(){
        return this.cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public String toString(){
        return name;
    }
}
