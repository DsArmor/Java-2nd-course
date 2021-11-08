public class SuperClass<E> {

    private E[] mas;

    public SuperClass(E[] mas) {
        this.mas = mas;
    }

    public E[] getMas() {
        return mas;
    }

    public void setMas(E[] mas) {
        this.mas = mas;
    }

    public E getIndex(int id){
        if (id < mas.length)
            return mas[id];
        else
            return null;
    }
}
