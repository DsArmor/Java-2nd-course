public interface Order {

    public boolean add(Item item);

    public boolean del(String name);

    public int delAll(String name);

    public int getSizeOrder();

    public Item[] getArrayOrders();

    public double priceOrder();

    public int numberSpecific(String name);

    public String[] getUniArrayOrder();

    public Item[] getOrdersByPrice();

}
