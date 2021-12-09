package Orders;

import CustomerInfo.Customer;
import Items.MenuItem;

import java.util.HashMap;


public class InternetOrder implements Order { //TODO fill methods.
    private ListNode head;
    private Customer customer;
    public InternetOrder(){
        head = new ListNode(null,null,null);
    }
    public InternetOrder(MenuItem[] item){
        ListNode current;
        for (int i = 0; i<item.length;i++){
            current = new ListNode(null,null,item[i]);
            if (i == 0){
                head = current;
                head.setNext(head);
                head.setPrev(head);
            }
            else {
                add(item[i]);
            }
        }
    }
    @Override
    public boolean add(MenuItem item) {
        if (head == null){
            head = new ListNode(null,null,item);
            head.setNext(head);
            head.setPrev(head);
            return true;
        }
        ListNode temp = head.getPrev();
        temp.setNext(new ListNode(head, temp, item));
        head.setPrev(temp.getNext());
        return true;
    }

    @Override
    public String[] itemsNames() {
        if (head == null){
            return null;
        }
        ListNode temp = head;
        HashMap<String,String> map = new HashMap<>();
        do{
            map.put(temp.getValue().getName(),temp.getValue().getName());
            temp = temp.getNext();
        }while(temp != head);

        String[] names;
        names = map.keySet().toArray(new String[map.size()]);

        return names;
    }

    @Override
    public int itemsQuantity() {
        if (head == null){
            return 0;
        }
        int count = 0;
        ListNode temp = head;
        do{
            count++;
            temp = temp.getNext();
        }while(temp != head);
        return count;
    }

    @Override
    public int itemQuantity(String itemName) {
        if (head == null){
            return 0;
        }
        int count = 0;
        ListNode temp = head;
        do{
            if (temp.getValue().getName().equals(itemName)){
                count++;
            }
            temp = temp.getNext();
        }while(temp != head);
        return count;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        if (head == null){
            return 0;
        }
        int count = 0;
        ListNode temp = head;
        do{
            if (temp.getValue().getName().equals(item)){
                count++;
            }
            temp = temp.getNext();
        }while(temp != head);
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        if (head == null){
            return null;
        }
        int size = 0;
        ListNode temp = head;
        do{
            temp = temp.getNext();
            size++;
        }while(temp != head);

        MenuItem[] items = new MenuItem[size];
        for (int i = 0;i < size;i++){
            items[i] = temp.getValue();
            temp = temp.getNext();
        }
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        if (head == null){
            return false;
        }
        ListNode temp = head.getPrev();
        do{
            if (temp.getValue().getName() == itemName && temp.getNext() != null && temp.getPrev() != null && temp.getNext() != temp && temp.getPrev() != temp){
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                return true;
            }
            else if (temp.getValue().getName() == itemName){
                head = null;
                return true;
            }
            temp = temp.getPrev();
        }while(temp != head);
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        if (head == null){
            return false;
        }
        ListNode temp = head.getPrev();
        do{
            if (temp.getValue().equals(item) && temp.getNext() != null && temp.getPrev() != null && temp.getNext() != temp && temp.getPrev() != temp){
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                return true;
            }
            else if (temp.getValue().equals(item)){
                head = null;
                return true;
            }
            temp = temp.getPrev();
        }while(temp != head);
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        if (head == null){
            return 0;
        }
        int count = 0;
        ListNode temp = head;
        int size = 0;
        do{
            temp = temp.getNext();
            size++;
        }while(temp != head);
        for (int i = 0; i < size;i++){
            if (temp.getValue().getName().equals(itemName) && temp.getNext() != null && temp.getPrev() != null && temp.getNext() != temp && temp.getPrev() != temp){
                if (temp == head){
                    head = temp.getNext();
                }
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                count++;
            }
            else if (temp.getValue().getName().equals(itemName)){
                head = null;
                count++;
            }
            temp = temp.getNext();
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem item) {
        if (head == null){
            return 0;
        }
        int count = 0;
        ListNode temp = head;
        int size = 0;
        do{
            temp = temp.getNext();
            size++;
        }while(temp != head);
        for (int i = 0; i < size;i++){
            if (temp.getValue().equals(item) && temp.getNext() != null && temp.getPrev() != null && temp.getNext() != temp && temp.getPrev() != temp){
                if (temp == head){
                    head = temp.getNext();
                }
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                count++;
            }
            else if (temp.getValue().equals(item)){
                head = null;
                count++;
            }
            temp = temp.getNext();
        }
        return count;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] item = getItems();
        if (item != null){
            quickSort(item,0,item.length-1);
            return item;
        }
        return null;
    }

    @Override
    public int costTotal() {
        if (head == null){
            return 0;
        }
        int cost = 0;
        ListNode temp = head;
        do{
            cost += temp.getValue().getCost();
            temp = temp.getNext();
        }while(temp != head);
        return cost;
    }

    @Override
    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
