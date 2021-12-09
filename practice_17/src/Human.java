public class Human {

    private Leg leg;
    private Head head;
    private Hand hand;

    public Human(Leg leg, Head head, Hand hand) {
        this.leg = leg;
        this.head = head;
        this.hand = hand;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return "Human{" +
                "leg=" + leg +
                ", head=" + head +
                ", hand=" + hand +
                '}';
    }
}

class Leg{

    private double size;
    private String footFor;

    public Leg() {
        size = 0;
    }

    public Leg(double size, String footFor) {
        this.size = size;
        this.footFor = footFor;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "size=" + size +
                ", footFor='" + footFor + '\'' +
                '}';
    }
}

class Head{

    private String spec;

    public Head(String spec) {
        this.spec = spec;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    @Override
    public String toString() {
        return "Head{" +
                "spec='" + spec + '\'' +
                '}';
    }
}

class Hand{

    private double size;

    public Hand() {
    }

    public Hand(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "size=" + size +
                '}';
    }
}

