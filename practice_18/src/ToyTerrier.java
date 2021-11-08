public class ToyTerrier extends Dog {
    public ToyTerrier(String furColor, int age) {
        super(furColor, age);
    }

    @Override
    public void toBark() {
        System.out.println("awff-awff");
    }
}
