import java.util.*;

public class Task1_3 {
    public static void Task1(){
        ArrayList<Integer> intArr = new ArrayList<>();
        for (int i = 0; i<10;i++){
            intArr.add((int)(Math.random()*100));
            System.out.print(intArr.get(i)+" ");
        }
        System.out.println(intArr.get(5));
        System.out.println(intArr.indexOf(5));
        intArr.set(9,5);
        System.out.println(intArr.lastIndexOf(5));
        intArr.sort(Comparator.naturalOrder());
        System.out.println(intArr.size());
        for (int x:intArr) {
            System.out.print(x+" ");
        }
        System.out.print("\n");
        List<Integer> sublist = intArr.subList(4,6);
        for (int x:sublist){
            System.out.print(x+" ");
        }
    }
    public static void Task2(){
        LinkedList<Integer> intList = new LinkedList<>();
        for (int i = 0;i<10;i++){
            intList.add((int)(Math.random()*100));
            System.out.print(intList.get(i)+" ");
        }
        System.out.println("\n"+intList.getFirst());
        intList.addFirst(5);
        System.out.println(intList.getFirst());
        System.out.println(intList.getLast());
        intList.addLast(10);
        System.out.println(intList.getLast());
        intList.removeLast();
        intList.removeFirst();
        System.out.println(intList.getFirst());
        System.out.println(intList.getLast());
    }
    public static void Task3(){
        MyArrayList arrayList = new MyArrayList(15);//work
        System.out.println(arrayList.size());
        for (int i = 0;i<15;i++){
            arrayList.add(i);//work
            System.out.print(arrayList.get(i)+" ");//work
        }
        System.out.println("\n"+arrayList.isEmpty());//work
        System.out.println(arrayList.contains(5));
        arrayList.set(4,25);
        System.out.println(arrayList.indexOf(5));
        System.out.println(arrayList.lastIndexOf(5));
        arrayList.add(15,90); //don`t work
        Object[] arr = arrayList.toArray();
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        List secondList = arrayList.subList(4,7);
        for (int i=0;i<secondList.size();i++){
            System.out.print(secondList.get(i)+" ");
        }
        System.out.println();
        for (int i = 15; i<30; i++){
            arrayList.add(i);//work
        }
        for (int i = 0; i<arrayList.size(); i++){
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.println();
        arrayList.remove(16);// don`t work
        for (int i =0;i<arrayList.size();i++){
            System.out.print(arrayList.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        Task1();
        System.out.println("Задание 2:");
        Task2();
        System.out.println("Задание 3:");
        Task3();
    }
}
class MyArrayList implements List{
    private Object[] arrayList;
    private int amountOfElementsInArray;
    @Override
    public int size() {
        return arrayList.length;
    }
    private boolean isArrayFull(){
        return arrayList.length == amountOfElementsInArray;
    }
    private int increaseArraySize(int size, String action) {
        if (action.equals("double")) {
            size = this.arrayList.length * 2;
        } else if (action.equals("increase")) {
            size = this.arrayList.length + 1;
        } else if (action.equals("decrease")){
            size = this.arrayList.length-1;
        }
        else{
            size = this.arrayList.length + size;
        }

        return size;
    }
    private void copyArray(int size, String action){
        size = increaseArraySize(size,action);
        Object[] arr = new Object[size];
        int temp = 0;
        for (int i = 0 ; i<this.arrayList.length;i++,temp++){
            if (this.arrayList[i] == null){
                temp--;
                continue;
            }
            arr[temp] = this.arrayList[i];
        }
        this.arrayList = arr;
    }
    public MyArrayList(int amountOfElementsInArray){
        if (amountOfElementsInArray>0) {
            this.amountOfElementsInArray = 0;
            this.arrayList = new Object[amountOfElementsInArray];
        }
        else{
            System.out.println("Неверный ввод, размер списка должен быть больше 0");
        }
    }
    private MyArrayList(int id1, int id2,int count, Object[] arr){
        if (id1 > 0 && id2 > id1 && id2 < count){
            Object[] temp = new Object[id2-id1];
            for (int i = 0;i<temp.length;i++){
                temp[i] = arr[i+id1];
            }
            amountOfElementsInArray = id2-id1;
            arrayList = temp;
        }
    }
    @Override
    public boolean isEmpty() {
        return amountOfElementsInArray == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(Object x:arrayList){
            if (x == o){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return arrayList;
    }

    @Override
    public boolean add(Object o) {
        if (isArrayFull()){
            copyArray(0,"increase");
        }
        this.arrayList[this.amountOfElementsInArray] = o;
        this.amountOfElementsInArray++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i =0;i<arrayList.length;i++){
            if (arrayList[i] == o){
                Object temp = arrayList[i];
                this.arrayList[i] = null;
                this.amountOfElementsInArray--;
                copyArray(0,"");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        arrayList = null;
        amountOfElementsInArray = 0;
    }

    @Override
    public Object get(int index) {
        if (index < arrayList.length)
            return this.arrayList[index];
        else
            return null;
    }

    @Override
    public Object set(int index, Object element) {
        if (index < arrayList.length){
            arrayList[index] = element;
            return arrayList[index];
        }
        return null;
    }

    @Override
    public void add(int index, Object element) {
        if (index >= this.arrayList.length){
            System.out.println("Индекс за пределами списка, элемент будет добавлен в конец списка");
            add(element);
        }
        else {
            if (isArrayFull()) {
                copyArray(0, "double");
            }
            Object temp = this.arrayList[index];
            arrayList[index] = element;
            Object temp2;
            for (int i = index; i < arrayList.length - 1; i++) {
                temp2 = arrayList[i + 1];
                arrayList[i + 1] = temp;
                temp = temp2;
            }
            copyArray(0, "");
            this.amountOfElementsInArray++;
        }
    }

    @Override
    public Object remove(int index) {
        if (index >= this.arrayList.length){
            System.out.println("Индекс за пределами списка");
            return null;
        }
        Object temp = arrayList[index];
        this.arrayList[index] = null;
        copyArray(0,"decrease");
        this.amountOfElementsInArray--;
        //copyArray(0,"");
        return temp;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0;i<arrayList.length;i++){
            if (arrayList[i] == o){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = arrayList.length-1;i>=0;i--){
            if (arrayList[i] == o){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public MyArrayList subList(int fromIndex, int toIndex) {
        return new MyArrayList(fromIndex,toIndex,this.amountOfElementsInArray,this.arrayList);
    }

    @Override
    public boolean retainAll(Collection c) {
        for (Object x:arrayList){
            if (!c.contains(x)){
                remove(x);
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object x:arrayList){
            if (c.contains(x)){
                remove(x);
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object x : arrayList) {
            if (!c.contains(x)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
