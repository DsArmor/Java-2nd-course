import java.util.HashMap;
import java.util.OptionalDouble;

public class OrderManager {

    HashMap<String, Order> tables;

    public Item createItem(ItemType itemType, double price, String name, String description) {

        Item item = null;

        switch (itemType) {
            case DISH -> item = new Drink(price, name, description);
            case DRINK -> item = new Dish(price, name, description);
        }

        return item;
    }

    public void add(String address, Order order) {
        tables.put(address, order);
    }

    public Order getOrder(String address) {
        return tables.get(address);
    }

    public void delOrder(String address) {
        tables.remove(address);
    }

    public void addItem(String address, Item item) {
        tables.get(address).add(item);
    }

    public Order[] getAllOrders() {
        Order[] orders = new Order[tables.size()];
        int i = 0;
        for (Order order : tables.values()) {
            orders[i] = order;
            i++;
        }
        return orders;
    }

    public double priceAllOrders() {
        Order[] orders = getAllOrders();
        double pricesAll = 0;
        for (Order order : orders) {
            pricesAll += order.priceOrder();
        }
        return pricesAll;
    }

    public int amountItem(String name) {
        int count = 0;
        for (Order order : tables.values()) {
            count += order.numberSpecific(name);
        }
        return count;
    }
}

enum ItemType {
    DISH,
    DRINK
}