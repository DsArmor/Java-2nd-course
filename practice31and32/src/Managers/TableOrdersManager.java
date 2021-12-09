package Managers;

import Items.MenuItem;
import Orders.Order;

import java.util.HashMap;

public class TableOrdersManager implements OrdersManager {
    private static final int amountOfTables = 20;
    private HashMap<Integer, Order> orderMap;
    public TableOrdersManager(){
        orderMap = new HashMap<>();
    }
    @Override
    public int itemsQuantity(String itemName) {
        Order[] orders = getOrders();
        int count = 0;
        for (int i = 0; i<orders.length;i++){
            for (int j = 0; j<orders.length;j++){
                if (orders[i].getItems()[j].getName().equals(itemName)){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        Order[] orders = getOrders();
        int count = 0;
        for (int i = 0; i<orders.length;i++){
            for (int j = 0; j<orders.length;j++){
                if (orders[i].getItems()[j].equals(item)){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public Order[] getOrders() {
        int count = 0;
        for (int i = 1; i<=amountOfTables;i++){
            if (orderMap.containsKey(i)){
                count++;
            }
        }
        Order[] orders = new Order[count];
        count = 0;
        for (int i = 1; i<=amountOfTables;i++){
            if (orderMap.containsKey(i)){
                orders[count++] = orderMap.get(i);
            }
        }
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int cost = 0;
        for (int i = 1; i<=amountOfTables;i++){
            if (orderMap.containsKey(i)){
                for (int j = 0; j < orderMap.get(i).getItems().length;j++){
                    cost +=  orderMap.get(i).getItems()[j].getCost();
                }
            }
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return orderMap.size();
    }

    public void add(Order order, int tableNumber){ //Добавить проверку есть ли уже такой адрес
        if (!orderMap.containsKey(tableNumber))
            orderMap.put(tableNumber,order);
    }
    public void addItem(MenuItem item, int tableNumber){//Добавить проверку есть ли такой номер стола
        if (orderMap.containsKey(tableNumber))
            orderMap.get(tableNumber).add(item);
    }
    public int freeTableNumber(){
        for (int i = 1; i<=amountOfTables;i++){
            if (!orderMap.containsKey(i)){
                return i;
            }
        }
        return -1;
    }
    public int[] freeTableNumbers(){
        int count = 0;
        for (int i = 1; i<=amountOfTables;i++){
            if (!orderMap.containsKey(i)){
                count++;
            }
        }
        int[] index = new int[count];
        count = 0;
        for (int i = 1; i<=amountOfTables;i++){
            if (!orderMap.containsKey(i)){
                index[count++] = i;
            }
        }
        return index;
    }
    public Order getOrder(int tableNumber){//Добавить проверку есть ли заказ на данный столик
        if (orderMap.containsKey(tableNumber)) {
            return orderMap.get(tableNumber);
        }
        else{
            return null;
        }
    }
    public void remove(int tableNumber){ //Добавить проверку есть ли заказ на данный столик
        if (orderMap.containsKey(tableNumber)) {
            orderMap.remove(tableNumber);
        }
    }
    public int remove(Order order){
        if (orderMap.containsValue(order)){

        }
        return 0;
    } //TODO
    public int removeAll(Order order){
        return 0;
    } // TODO

}
