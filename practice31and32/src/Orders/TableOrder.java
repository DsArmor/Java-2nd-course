package Orders;

import CustomerInfo.Customer;
import Items.MenuItem;
import Orders.Order;

import java.util.HashMap;


public class TableOrder implements Order {
    private int size;
    private MenuItem[] items;
    public TableOrder(){
        this.size = 0;
        items = new MenuItem[10];
    }
    public TableOrder(MenuItem[] items){
        this.items =  items;
        this.size = items.length;
    }
    @Override
    public boolean add(MenuItem item) {

        if (size == items.length){
            //skopirovat` array
            MenuItem[] temp = new MenuItem[size+1];
            System.arraycopy(items,0,temp,0,size);
            items = temp;
            items[size++] = item;
            return true;
        }
        items[size++] = item;
        return true;
    }

    @Override
    public String[] itemsNames() {
        HashMap<String,String> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(items[i].getName(), items[i].getName());
        }
        String[] names;
        names = map.keySet().toArray(new String[map.size()]);

        return names;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        int count = 0;
        for (int i = 0; i < size; i++){
            if(items[i].getName().equals(itemName)){
                count++;
            }
        }
        return count;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        int count = 0;
        for (int i = 0; i < size; i++){
            if(items[i].equals(item)){
                count++;
            }
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        int index = -1;
        for (int i = size-1; i > 0 ; i--){
            if (items[i].getName().equals(itemName)){
                index = i;
                items[i] = null;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                items[i] = items[i + 1];
            }
            size--;
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        int index = -1;
        for (int i = size-1; i > 0 ; i--){
            if (items[i].equals(item)){
                index = i;
                items[i] = null;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                items[i] = items[i + 1];
            }
            size--;
        }
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        for (int i = size-1; i > 0; i--){
            if (items[i].getName().equals(itemName)){
                remove(itemName);
                count++;
            }
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem item) {
        int count = 0;
        for (int i = size-1; i > 0; i--){
            if (items[i].equals(item)){
                remove(item);
                count++;
            }
        }
        return count;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        quickSort(items,0,Math.min(items.length,size)-1);
        return items;
    }

    @Override
    public int costTotal() {
        int total = 0;
        for (int i = 0; i < size; i++){
            total += items[i].getCost();
        }
        return total;
    }

    @Override
    public Customer getCustomer() {
        return null;
    }

    @Override
    public void setCustomer(Customer customer) {

    }

}
