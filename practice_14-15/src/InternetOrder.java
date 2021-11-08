public class InternetOrder implements Order {

    private Node first;

    private static class Node {
        Node next;
        Node prev;
        Item item;

        public Node(Node next, Node prev, Item item) {
            this.next = next;
            this.prev = prev;
            this.item = item;
        }
    }

    public InternetOrder() {
        first = new Node(null, null, null);
    }

    public InternetOrder(Item[] items) {

        first = new Node(null, null, null);

        Node current = null;
        Node prev = null;

        for (int i = 0; i < items.length; i++) {
            current = new Node(null, prev, items[i]);
            if (i > 0)
                prev.next = current;
            if (i == 0)
                first.next = current;
            prev = current;
        }
        first.next.prev = current;
        current.next = first.next;
    }

    @Override
    public boolean add(Item item) {
        Node temp = first.next;
        if (temp == null) {
            first.next = new Node(null, null, item);
            return true;
        }
        if (temp.next == null) {
            first.next.next = new Node(null, null, item);
            first.next.prev = first.next.next;
            first.next.next.next = first.next;
            first.next.next.prev = first.next;
            return true;
        }
        // && temp.next != null
        while (temp.next != first.next) {
            temp = temp.next;
        }
        temp.next = new Node(first.next, temp, item);
        first.next.prev = temp.next;
        return true;
    }

    @Override
    public boolean del(String name) {
        Node temp = first.next;
        Node forDel = null;
        if (temp == null)
            return false;
        while (temp.next != null && temp.next != first.next) {
            if (temp.item.getName().equals(name)) {
                forDel = temp;
            }
            temp = temp.next;
        }
        if (forDel != null) {
            if (forDel == first.next) {
                first.next = forDel.next;
            }
            forDel.prev.next = forDel.next;
            forDel.next.prev = forDel.prev;
            return true;
        }
        return false;
    }

    @Override
    public int delAll(String name) {
        Node temp = first.next;
        if (temp == null)
            return 0;
        if (temp.item.getName().equals(name) && temp.next == null) {
            first.next = null;
            return 1;
        }
        int count = 0;
        while (temp.next != null && temp.next != first.next) {
            if (temp.item.getName().equals(name)) {
                if (temp == first.next)
                    first.next = temp.next;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                count++;
            }
            temp = temp.next;
        }
        if (temp.item.getName().equals(name)) {
            if (temp == first.next)
                first.next = temp.next;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            count++;
        }
        return count;
    }

    @Override
    public int getSizeOrder() {
        int count = 0;
        Node temp = first.next;
        if (temp != null) {
            count++;
            while (temp.next != null && temp.next != first.next) {
                count++;
                temp = temp.next;
            }
        }
        return count;
    }

    @Override
    public Item[] getArrayOrders() {
        Node temp = first.next;
        int count = getSizeOrder();
        Item[] items = new Item[count];
        for (int i = 0; i < count; i++) {
            items[i] = temp.item;
            temp = temp.next;
        }
        return items;
    }

    @Override
    public double priceOrder() {
        Node temp = first.next;
        if (temp == null)
            return 0;
        if (temp.next == null) {
            return temp.item.getPrice();
        }
        double sum = 0;
        while (temp.next != first.next) {
            sum += temp.item.getPrice();
            temp = temp.next;
        }
        return sum;
    }

    @Override
    public int numberSpecific(String name) {
        Node temp = first.next;
        if (temp == null)
            return 0;
        if (temp.item.getName().equals(name) && temp.next == null)
            return 1;
        int count = 0;
        while (temp.next != null && temp.next != first.next) {
            if (temp.item.getName().equals(name))
                count++;
            temp = temp.next;
        }
        if (temp.item.getName().equals(name))
            count++;
        return count;
    }

    @Override
    public String[] getUniArrayOrder() {
        Item[] items = getArrayOrders();
        for (int i = 0; i < items.length; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (items[i].getName().equals(items[j].getName())) {
                    Item[] items1 = new Item[items.length - 1];
                    System.arraycopy(items, 0, items1, 0, j);
                    System.arraycopy(items, j + 1, items1, j, items.length - 1 - j);
                    items = items1;
                    j--;
                }
            }
        }
        String[] strings = new String[items.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = items[i].getName();
        }
        return strings;
    }

    private void swap(Item[] items, int i, int j) {
        Item temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    @Override
    public Item[] getOrdersByPrice() {
        Item[] items = getArrayOrders();
        for (int i = 0; i < items.length; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (items[i].getName().equals(items[j].getName())) {
                    Item[] items1 = new Item[items.length - 1];
                    System.arraycopy(items, 0, items1, 0, j);
                    System.arraycopy(items, j + 1, items1, j, items.length - 1 - j);
                    items = items1;
                    j--;
                }
            }
        }
        for (int i = 0; i < items.length; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (items[j].getPrice() > items[i].getPrice())
                    swap(items, i, j);
            }
        }
        return items;
    }

}
