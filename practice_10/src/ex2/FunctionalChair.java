package ex2;



public class FunctionalChair implements Chair {
    public int sum(int a, int b){
        return a*b;
    }


    @Override
    public String use() {
        return "Functional chair";
    }
}
