package Orders;


import Items.MenuItem;

public class ListNode {
    private ListNode next;
    private ListNode prev;
    private MenuItem value;

    public ListNode(ListNode next,ListNode prev, MenuItem value) {
        this.next = next;
        this.prev = prev;
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPrev() {
        return prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public MenuItem getValue() {
        return value;
    }

    public void setValue(MenuItem value) {
        this.value = value;
    }
}
