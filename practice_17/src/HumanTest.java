public class HumanTest {

    public static void main(String[] args) {
        Human human = new Human(new Leg(), new Head("Engineer"), new Hand());
        System.out.println(human);
    }
}
