package Managers;

import CustomerInfo.Address;
import Items.MenuItem;
import Orders.Order;

import java.util.HashMap;

public class InternetOrdersManager implements OrdersManager {
    private QueueNode head;
    private HashMap<Address, Order> addressOrderHashMap;

    public InternetOrdersManager(){
        addressOrderHashMap = new HashMap<>();
    }
    public Order getOrder(Address address){
        if (addressOrderHashMap.containsKey(address)){
            return addressOrderHashMap.get(address);
        }
        else {
            return null;
        }
    }
    public boolean add(Order order){
        if (head == null){
            head = new QueueNode(null,null, order);
            head.setNext(head);
            head.setPrev(head);
            if (!addressOrderHashMap.containsKey(order.getCustomer().getAddress())) {
                addressOrderHashMap.put(order.getCustomer().getAddress(), order);
            }
            return true;
        }
        if (!addressOrderHashMap.containsKey(order.getCustomer().getAddress())) {
            addressOrderHashMap.put(order.getCustomer().getAddress(), order);
        }
        QueueNode temp = head.getPrev();
        temp.setNext(new QueueNode(head, temp, order));
        head.setPrev(temp.getNext());
        return true;
    }
    public void remove(Address address){//добавить проверку и метод
        if (addressOrderHashMap.containsKey(address)) {
            addressOrderHashMap.remove(address);
        }
    }
    public Order remove(){
        if (head == null){
            return null;
        }
        QueueNode temp = head.getPrev();
        head.getPrev().getPrev().setNext(head);
        head.setPrev(temp.getPrev());
        return temp.getValue();
    } //TODO
    public Order order(){
        if (head == null){
            return null;
        }
        return head.getValue();
    } //TODO

    @Override
    public int itemsQuantity(String itemName) {
        Order[] orders = getOrders();
        int count = 0;
        for (int i = 0; i < orders.length; i++){
            for (int j = 0; j < orders[i].getItems().length; j++){
                if (orders[i].getItems()[j].getName() == itemName){
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
        for (int i = 0; i < orders.length; i++){
            for (int j = 0; j < orders[i].getItems().length; j++){
                if (orders[i].getItems()[j].equals(item)){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public Order[] getOrders() {
        if (head == null){
            return null;
        }
        int size = 0;
        QueueNode temp = head;
        do{
            temp = temp.getNext();
            size++;
        }while(temp != head);

        Order[] orders = new Order[size];
        for (int i = 0;i < size;i++){
            orders[i] = temp.getValue();
            temp = temp.getNext();
        }
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        Order[] orders = getOrders();
        int cost = 0;
        for (int i = 0; i < orders.length; i++){
            for (int j = 0; j < orders[i].getItems().length; j++){
                cost += orders[i].getItems()[j].getCost();
            }
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        Order[] orders = getOrders();
        return orders.length;
    }
}
