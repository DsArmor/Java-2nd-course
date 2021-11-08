package ex2My;

public class Client {
    private final ChairFactory chairFactory;

    public Client(ChairFactory chairFactory) {
        this.chairFactory = chairFactory;
    }

    public Chair orderChairType(ChairType chairType)
    {
        return chairFactory.createChair(chairType);
    }

    public void Sit(Chair chair){
        System.out.println("Sit on a " + chair.chairType());
    }
}

class Main{
    public static void main(String[] args) {
        Client client = new Client(new ChairFactory());
        client.Sit(client.orderChairType(ChairType.FUNCTIONAL));
        client.Sit(client.orderChairType(ChairType.MAGIC));
        client.Sit(client.orderChairType(ChairType.VICTORIAN));
    }
}
