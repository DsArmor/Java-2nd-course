public class GermanShepherd extends Dog {
    public GermanShepherd(String furColor, int age) {
        super(furColor, age);
    }

    @Override
    public void toBark() {
        System.out.println("arrrgh-arrrgh");
    }
}
