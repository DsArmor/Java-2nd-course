package ex2;

public class Client {
    public Chair chair;

    public void sit(){
        System.out.println(chair.use());
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}

class Main{
    public static void main(String[] args) {
        AbstractChairFactory factory = new ChairFactory();
        Client client = new Client();
        client.setChair(factory.createFunctionalChair());
        client.sit();
        client.setChair(factory.createMagicChair());
        client.sit();
        client.setChair(factory.createVictorianChair());
        client.sit();
    }
}
