public class Test {
    public static void main(String[] args) {

        Item[] items = new Item[2];
        items[0] = new Dish("ger", "fergrg");
        items[1] = new Drink("ergre", "ierg");

        InternetOrder internetOrder = new InternetOrder(items);
        internetOrder.add(new Drink(2.0, "gegr", "gregqe"));
        internetOrder.add(new Dish(5.0, "rgemkler", "ej2qqwew"));
        internetOrder.add(new Drink(2.0, "gegr", "grege"));


        System.out.println(internetOrder.getSizeOrder());
        for (Item item : internetOrder.getArrayOrders())
            System.out.println(item);
        System.out.println(internetOrder.priceOrder());
        System.out.println(internetOrder.numberSpecific("gegr"));
        for (String s : internetOrder.getUniArrayOrder())
            System.out.println(s + "  ");
        for (Item item : internetOrder.getOrdersByPrice())
            System.out.println(item);

        System.out.println();
        internetOrder.del("ger");
        for (Item item : internetOrder.getArrayOrders())
            System.out.println(item);
        internetOrder.delAll("gegr");
        System.out.println();
        for (Item item : internetOrder.getArrayOrders())
            System.out.println(item);

        System.out.println("\n\n\n\n");

        RestaurantOrder restaurantOrder = new RestaurantOrder();
        restaurantOrder.add(new Drink("ergre", "ierg"));
        restaurantOrder.add(new Dish("ger", "fergrg"));
        restaurantOrder.add(new Drink(2.0, "gegr", "grqfege"));
        restaurantOrder.add(new Dish(5.0, "rgemkler", "ejfwef2qqwew"));
        restaurantOrder.add(new Drink(2.0, "gegr", "greergrge"));

        System.out.println(restaurantOrder.getSizeOrder());
        for (Item item : restaurantOrder.getArrayOrders())
            System.out.println(item);
        System.out.println(restaurantOrder.priceOrder());
        System.out.println(restaurantOrder.numberSpecific("gegr"));
        for (String s : restaurantOrder.getUniArrayOrder())
            System.out.println(s + "  ");
        for (Item item : restaurantOrder.getOrdersByPrice())
            System.out.println(item);

        System.out.println();
        restaurantOrder.del("ger");
        for (Item item : restaurantOrder.getArrayOrders())
            System.out.println(item);
        restaurantOrder.delAll("gegr");
        System.out.println();
        for (Item item : restaurantOrder.getArrayOrders())
            System.out.println(item);
    }
}
