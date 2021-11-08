public class RestaurantOrder implements Order {

    private final OrderManager orderManager;

    private Item[] items;
    private int size;

    public RestaurantOrder() {
        orderManager = new OrderManager();
        items = new Item[16];
        size = 0;
    }

    private void resize() {
        Item[] temp = new Item[size];
        System.arraycopy(items, 0, temp, 0, size);
        items = new Item[size * 2];
        System.arraycopy(temp, 0, items, 0, size);
    }

    public void orderItem(ItemType type, double price, String name, String description) {
        Item item = orderManager.createItem(type, price, name, description);
        if (items.length == size)
            resize();
        items[size] = item;
        size++;
    }

    @Override
    public boolean add(Item item) {
        if (items.length == size)
            resize();
        items[size] = item;
        size++;
        return true;
    }

    @Override
    public boolean del(String name) {
        int k = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(name))
                k = i;
        }
        if (k != -1) {
            System.arraycopy(items, k + 1, items, k, items.length - k - 1);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int delAll(String name) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(name)) {
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                size--;
                i--;
            }
        }
        return count;
    }

    @Override
    public int getSizeOrder() {
        return size;
    }

    @Override
    public Item[] getArrayOrders() {
        Item[] items1 = new Item[size];
        System.arraycopy(items, 0, items1, 0, size);
        return items1;
    }

    @Override
    public double priceOrder() {
        double allPrice = 0;
        for (int i = 0; i < size; i++) {
            allPrice += items[i].getPrice();
        }
        return allPrice;
    }

    @Override
    public int numberSpecific(String name) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(name))
                count++;
        }
        return count;
    }

    @Override
    public String[] getUniArrayOrder() {
        Item[] tempItems = new Item[size];
        System.arraycopy(items, 0, tempItems, 0, size);
        for (int i = 0; i < tempItems.length; i++) {
            for (int j = i + 1; j < tempItems.length; j++) {
                if (tempItems[j].getName().equals(tempItems[i].getName())) {
                    Item[] items1 = new Item[tempItems.length - 1];
                    System.arraycopy(tempItems, 0, items1, 0, j);
                    System.arraycopy(tempItems, j + 1, items1, j, tempItems.length - 1 - j);
                    tempItems = items1;
                    j--;
                }
            }
        }
        String[] strings = new String[size];
        for (int i = 0; i < tempItems.length; i++) {
            strings[i] = tempItems[i].getName();
        }
        return strings;
    }

    @Override
    public Item[] getOrdersByPrice() {
        Item[] tempItems = new Item[size];
        System.arraycopy(items, 0, tempItems, 0, size);
        for (int i = 0; i < tempItems.length; i++) {
            for (int j = i + 1; j < tempItems.length; j++) {
                if (tempItems[j].getName().equals(tempItems[i].getName())) {
                    Item[] items1 = new Item[tempItems.length - 1];
                    System.arraycopy(tempItems, 0, items1, 0, j);
                    System.arraycopy(tempItems, j + 1, items1, j, tempItems.length - 1 - j);
                    tempItems = items1;
                    j--;
                }
            }
        }
        for (int i = 0; i < tempItems.length; i++) {
            for (int j = i + 1; j < tempItems.length; j++) {
                if (tempItems[i].getPrice() > tempItems[j].getPrice()) {
                    Item temp = tempItems[i];
                    tempItems[i] = tempItems[j];
                    tempItems[j] = temp;
                }
            }
        }
        return tempItems;
    }
}
