package ex2;


public class VictorianChair implements Chair {

    private int age;

    public int getAge() {
        return age;
    }

    public VictorianChair(int age) {
        this.age = age;
    }

    @Override
    public String use() {
        return "Victorian chair";
    }
}
