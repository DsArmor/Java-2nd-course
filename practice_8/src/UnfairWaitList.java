public class UnfairWaitList<E> extends WaitList<E>{
    public UnfairWaitList() {
        super();
    }

    public void remove(E element) {
        if (content.peek() == element)
            return ;
        for (E temp : content)
        {
            if (temp == element){
                content.remove(temp);
                break;
            }
        }
    }

    public void moveToBack(E element)
    {
        if (content.peek() == element)
        {
            content.offer(element);
            content.remove();
        }
    }
}
