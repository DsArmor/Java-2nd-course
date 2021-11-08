package ex2;



public class MagicChair implements Chair {
    public void doMagic(){}


    @Override
    public String use() {
        return "Magic chair";
    }
}
