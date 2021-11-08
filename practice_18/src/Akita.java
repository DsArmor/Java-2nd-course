public class Akita extends Dog {
    public Akita(String furColor, int age) {
        super(furColor, age);
    }

    @Override
    public void toBark() {
        System.out.println("auuu-auuu");
    }
}
