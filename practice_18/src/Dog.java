public abstract class Dog {
    private String furColor;
    private int age;

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(String furColor, int age) {
        this.furColor = furColor;
        this.age = age;
    }

    public abstract void toBark();
}
